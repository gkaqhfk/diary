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
				<th>name</th>
				<th>id</th>
				<th>pw</th>
				<th>tel</th>
				<th>gender</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${members}" var="member">
				<tr>
					<td>${member.name}</td>
					<td>${member.id}</td>
					<td>${member.pw}</td>
					<td>${member.tel}</td>
					<td>${member.gender}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
