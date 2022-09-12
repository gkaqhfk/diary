<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org">
<head>
	<title>Please Log In</title>
</head>
<body>
	<h1>Please Log In</h1>
	<div th:if="${param.error}">
		Invalid username and password.</div>
	<div th:if="${param.logout}">
		You have been logged out.</div>
	<form th:action="@{/login}" method="post">
		<div>
			<label>
				<input type="text" name="username" placeholder="Username" />
			</label>
		</div>
		<div>
			<label>
				<input type="password" name="password" placeholder="Password" />
			</label>
		</div>
		<input type="submit" value="Log in" />
	</form>
</body>
</html>
