package com.sample.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dto.PostCommentListDto;
import com.sample.dto.PostDetailDto;
import com.sample.dto.PostListDto;
import com.sample.exception.ApplicationException;
import com.sample.mapper.PostCommentMapper;
import com.sample.mapper.PostMapper;
import com.sample.mapper.UserMapper;
import com.sample.utils.Pagination;
import com.sample.vo.AttachedFile;
import com.sample.vo.Comment;
import com.sample.vo.Post;
import com.sample.vo.Tag;
import com.sample.vo.User;
import com.sample.web.request.PostModifyForm;
import com.sample.web.request.PostRegisterForm;

@Service
@Transactional
public class PostService {
	
	@Autowired
	private PostCommentMapper postCommentMapper;
	@Autowired
	private PostMapper postMapper;
	@Autowired
	private UserMapper userMapper;
	
	// 게시글 등록 서비스
	public void insertPost(String userId, PostRegisterForm postRegisterForm) {
		User savedUser = userMapper.getUserById(userId);
		if(savedUser == null) {
			throw new ApplicationException("로그인 후 이용가능한 서비스입니다.");
		}
		
		// SPRING_POSTS 테이블에 게시글 정보 저장
		Post post = new Post();
		post.setUserId(savedUser.getId());
		BeanUtils.copyProperties(postRegisterForm, post);
		postMapper.insertPost(post);

		// SPRING_POST_ATTACHED_FILES 테이블에 게시글 첨부파일 정보 저장
		if(postRegisterForm.getFilename() != null) {
			AttachedFile attachedFile = new AttachedFile();
			attachedFile.setPostno(post.getNo());
			attachedFile.setFileName(postRegisterForm.getFilename());
			
			postMapper.insertAttachedFile(attachedFile);
		}
		
		// SPRING_POST_TAGS 테이블에 게시글 태그 정보 저장
		if(postRegisterForm.getTags() != null) {
			List<String> tags = postRegisterForm.getTags();
			for(String tagContent : tags) {
				Tag tag = new Tag(post.getNo(), tagContent);
				postMapper.insertTag(tag);
			}
		}
	}
	
	// 게시글의 조회수를 증가시키는 서비스
	public void increaseReadCount(int postNo) {
		Post post = postMapper.getPostByNo(postNo);
		if (post == null) {
			throw new ApplicationException("["+postNo+"] 번 게시글이 존재하지 않습니다.");
		}
		if ("Y".equals(post.getDeleted())) {
			throw new ApplicationException("["+postNo+"] 번 게시글은 삭제된 게시글입니다.");
		}
		
		post.setReadCount(post.getReadCount() + 1);
		postMapper.updatePost(post);
	}
	
	
	// 게시글의 상세정보(게시글 벙보와 댓글목록 정보)를 제공하는 서비스
	public PostDetailDto getPostDetail(int postNo) {
		// 게시글 정보 조회
		PostDetailDto postDetailDto = postMapper.getPostDetailByNo(postNo);
		if (postDetailDto == null) {
			throw new ApplicationException("["+postNo+"] 번 게시글이 존재하지 않습니다.");
		}
		
		// 댓글 정보 조회
		List<PostCommentListDto> postCommentListDtos = postCommentMapper.getPostCommentsByPostNo(postNo);
		postDetailDto.setComments(postCommentListDtos);
		
		// 첨부파일 정보 조회
		List<AttachedFile> attachedFiles = postMapper.getAttachedFilesByPostNo(postNo);
		postDetailDto.setAttachedFiles(attachedFiles);
		
		// 태그 정보 조회
		List<Tag> tags = postMapper.getTagsByPostNo(postNo);
		postDetailDto.setTags(tags);
		
		return postDetailDto;
	}

	public Map<String, Object> getPosts(int page) {
		int totalRows = postMapper.getTotalRows();
		Pagination pagination = new Pagination(page, totalRows);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("begin", pagination.getBegin());
		param.put("end", pagination.getEnd());
		
		List<PostListDto> posts = postMapper.getPosts(param);
		
		Map<String, Object> result = new HashMap<>();
		result.put("posts", posts);
		result.put("pagination", pagination);
		
		return result;
	}
	
	// 댓글을 등록하는 기능
		public void insertComment(String userId, String content, int postNo) {
			Post post = postMapper.getPostByNo(postNo);
			if (post == null) {
				throw new ApplicationException("["+postNo+"] 번 게시글이 존재하지 않습니다.");
			}
			
			Comment comment = new Comment();
			comment.setUserId(userId);
			comment.setContent(content);
			comment.setPostNo(postNo);		
			postCommentMapper.insertPostComment(comment);
			
			post.setCommentCount(post.getCommentCount() + 1);
			postMapper.updatePost(post);		
		}

		public void updatePost(PostModifyForm postModifyForm) {
			Post post = new Post();
			BeanUtils.copyProperties(postModifyForm, post);
			
			postMapper.updatePost(post);
		}

}
