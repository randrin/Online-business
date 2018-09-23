<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3 class="my-4"><b>Online Shopping</b></h3>
<br>
<p id="date" style="font-weight: bold;"></p>
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