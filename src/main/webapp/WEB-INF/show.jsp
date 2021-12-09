<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- local JS -->
<script type="text/javascript" src="js/app.js"></script>
<!-- Bootstrap JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Languages</title>
</head>
<body>

	<div class="container">

		<p>
			Name
			<c:out value="${ language.name }" />
		</p>
		<p>
			Creator
			<c:out value="${ language.creator }" />
		</p>
		<p>
			Version
			<c:out value="${ language.currentVersion }" />
		</p>
		<a class="btn" href="/languages/${ language.id }/edit">Edit</a>
		<form action="/languages/${ language.id }" method="post">
			<input type="hidden" name="_method" value="delete"> <input
				class="btn" type="submit" value="Delete">
		</form>
	</div>

</body>
</html>