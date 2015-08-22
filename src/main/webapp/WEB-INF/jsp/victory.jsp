<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css" />" />
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#newGameButton').click(function() {
				window.location = '/game/new';
			});
		});
	</script>
</head>
<body>
<div id="center-pane">

<div id="history">
	<div id="recent-attacks">Recent Attacks</div>
	<table id="history-table">
	<tr>
		<th>Word</th>
		<th>Hits</th>
	</tr>
	<c:forEach var="attack" items="${sessionScope.game.attacks}">
	<tr>
		<td><c:out value="${attack.word}"/></td>
		<td><c:out value="${attack.hits}"/></td>
	</tr>
	</c:forEach>
	</table>
</div>

<div id="main">
	<div>
		<img src="<c:url value="/images/victory.jpg" />" />
	</div>
	<div>
		You have won!
	</div>
	<div>
		<button id="newGameButton">New Game</button>
	</div>
</div>

</div>
</body>
</html>