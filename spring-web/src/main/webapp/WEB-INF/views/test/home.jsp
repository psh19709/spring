<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
<title>테스트페이지</title>
</head>
<body>
<c:set var="menu" value="test" />
<%@include file="common/sidebar.jsp" %>
	<div class="container">
		<div class="container">
		   <div class="mb-3">
		      <div class="col-9">
		         <div class="border p-3 bg-light">
		            <h1 class="mb-4">스마트 오피스 애플리케이션</h1>
		            <p>테스트 페이지입니다.</p>
		         </div>
		      </div>
		   </div>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</body>
</html>