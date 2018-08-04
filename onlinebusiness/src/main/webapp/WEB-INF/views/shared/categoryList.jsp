<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="list-group">
	<c:forEach items="${categorydao}" var="category">
		<a href="#" class="list-group-item">${category.name}</a>
	</c:forEach>
</div>