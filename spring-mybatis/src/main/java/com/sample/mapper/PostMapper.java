package com.sample.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sample.vo.Post;

@Mapper
public interface PostMapper {
	
	List<Post> getPosts(Map<String, Object> param);
	void deletePosts(@Param("numbers") List<Integer> numbers);

}
