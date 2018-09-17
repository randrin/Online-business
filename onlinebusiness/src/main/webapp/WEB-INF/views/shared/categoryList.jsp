<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 class="my-4"><b>Shopping Online</b></h1>
<br>
<p id="date"></p>
<div class="container">
	<div class="row">
	  <p class="unit" id="hours"></p>
	  <p class="unit" id="minutes"></p>
	  <p class="unit" id="seconds" style="color: yellow;"></p>
	  <p class="unit" id="ampm"></p>
	</div>
</div>
<br>
<div class="list-group">
	<c:forEach items="${categorydao}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id="a_${category.name}"><b>${category.name}</b></a>
	</c:forEach>
</div>