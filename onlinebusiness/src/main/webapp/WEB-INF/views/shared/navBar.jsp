<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home"><b>Online Shopping</b></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item styleItem" id="home">
              <a class="nav-link" href="${contextRoot}/home"><b>HOME</b>
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item styleItem" id="about">
              <a class="nav-link" href="${contextRoot}/about"><b>ABOUT</b></a>
            </li>
            <li class="nav-item styleItem" id="services">
              <a class="nav-link" href="${contextRoot}/services"><b>SERVICES</b></a>
            </li>
            <li class="nav-item styleItem" id="listOfProducts">
              <a class="nav-link" href="${contextRoot}/show/all/products"><b>PRODUCTS</b></a>
            </li>
            <li class="nav-item dropdown styleItem" id="manageProducts">
              <a class="nav-link dropdown-toggle" id="navbarDropdownManageLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#"><b>MANAGE PRODUCT</b></a>
            	<div class="dropdown-menu" aria-labelledby="navbarDropdownManageLink">
		          <a class="dropdown-item" href="${contextRoot}/manage/products">List Products</a>
		          <a class="dropdown-item" href="${contextRoot}/manage/new/product">Add New Product</a>
		        </div>
            </li>
            <li class="nav-item styleItem" id="contact">
              <a class="nav-link" href="${contextRoot}/contact"><b>CONTACT</b></a>
            </li>
          </ul>
        </div>
      </div>
    </nav>