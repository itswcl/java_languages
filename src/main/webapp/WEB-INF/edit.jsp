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
		<div class="row">
			<form:form action="/languages/${ language.id }" method="post"
				modelAttribute="language">
				<input type="hidden" name="_method" value="put">

				<p>
					<form:label path="name">Name</form:label>
					<form:errors style="color: red;" path="name" />
					<form:input path="name" />
				</p>
				<p>
					<form:label path="creator">Creator Name</form:label>
					<form:errors style="color: red;" path="creator" />
					<form:input path="creator" />
				</p>
				<p>
					<form:label path="currentVersion">Current Version</form:label>
					<form:errors style="color: red;" path="currentVersion" />
					<form:input path="currentVersion" />
				</p>
				<input type="submit" value="submit" />
			</form:form>
		</div>
	</div>

</body>
</html>