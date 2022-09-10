<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Member</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>password</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${members}" var="member">
				<tr>
					<td>${member.memberId}</td>
					<td>${member.password}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
