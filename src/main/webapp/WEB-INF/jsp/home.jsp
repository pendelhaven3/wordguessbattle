<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
$(document).ready(function() {
	$('#button').click(function() {
		window.location = 'game/new';
	})
});
</script>

<button id="button">
	<c:if test="${sessionScope.game == null}">New</c:if><c:if test="${sessionScope.game != null}">Resume</c:if> Game
</button>