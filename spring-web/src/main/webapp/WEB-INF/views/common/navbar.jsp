<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
	<div class="container">
		<ul class="navbar-nav me-auto">
			<li class="nav-item"><a class="nav-link ${menu eq 'home' ? 'active' : '' }" href="/home">샘플 애플리케이션</a></li>
		</ul>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
			<li class="nav-item"><a class="nav-link ${menu eq 'login' ? 'active' : '' }" href="/login">로그인</a></li>
			<li class="nav-item"><a class="nav-link ${menu eq 'register' ? 'active' : '' }" href="/register">회원가입</a></li>
		</ul>
	</div>
</nav>