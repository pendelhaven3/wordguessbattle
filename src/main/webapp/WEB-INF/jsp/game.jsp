<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css" />" />
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#word').focus();
			$('#fireButton').click(function() {
				$('#attackForm').submit();
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
		<img src="<c:url value="/images/missile.jpg" />" />
	</div>
	<div>
		Set the attack word to use on the missiles.
	</div>
	<div>
		<form id="attackForm" action="/game/attack">
			<input type="text" id="word" name="word" placeHolder="Set attack word here" autocomplete="off" />
		</form>
	</div>
	<div>
		<button id="fireButton">Fire!</button>
	</div>
</div>

</div>
</body>
</html>