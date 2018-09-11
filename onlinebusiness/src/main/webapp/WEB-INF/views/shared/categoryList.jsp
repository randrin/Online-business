<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>startTime();</script>
<h2 startTime()" class="my-4" id="time"></h2>
<h1 class="my-4">Shopping Online</h1>
<div class="list-group">
	<c:forEach items="${categorydao}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id="a_${category.name}"><b>${category.name}</b></a>
	</c:forEach>
</div>