<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css" />" />
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#button').click(function() {
				window.location = 'game/new';
			})
		});
	</script>
</head>
<body>
<div id="center-pane">
<div id="home-main">

	<div>
		<img src="<c:url value="/images/title.jpg" />" />
	</div>

	<div>
		<img src="<c:url value="/images/home.jpg" />" />
	</div>

	<div>
		<button id="button">
			<c:if test="${sessionScope.game == null}">New</c:if><c:if test="${sessionScope.game != null}">Resume</c:if> Game
		</button>
	</div>

</div>
</div>
</body>
</html>