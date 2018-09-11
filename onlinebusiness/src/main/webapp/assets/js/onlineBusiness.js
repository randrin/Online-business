$(document).ready(function() {

	//Code for Menu Bar Activation
	switch (menu) {
		case 'About Us':
			$('#about').addClass('active');
			break;
	
		case 'Services':
			$('#services').addClass('active');
			break;
	
		case 'List of Products':
			$('#listOfProducts').addClass('active');
			break;
	
		case 'Manage Products':
			$('#manageProducts').addClass('active');
			break;
		
		case 'New Product':
			$('#manageProducts').addClass('active');
			break;
		
		case 'Edit Product':
			$('#manageProducts').addClass('active');
			break;
			
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
			
		case 'My Data Informations':
			$('#infosUser').addClass('active');
			break;
			
		default:
			$('#home').addClass('active');
			$('#a_'+menu).addClass('active');
			break;
	}
	
	// Hover dropdown
	$('ul.nav li.dropdown').hover(function() {
		  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
		}, function() {
		  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
		});
	
	// For handling CSRF token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length > 0 && header.length > 0) {		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {			
			xhr.setRequestHeader(header,token);			
		});				
	}
	
	//Code for DataTable fetch Data Json
	var $table = $('#getListProducts');
	
	if ($table.length){
		console.log('Inside the table Datatables ...');
		var jsonUrl = '';
		
		if (window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'+window.categoryId+'/products';
		}
		
		$table.DataTable({
			lengthMenu: [[3,5,10,-1], ['3 Products', '5 Products', '10 Products', 'All Products']],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: 
				[
				 	{data: 'code',
				 		bSortable: false,
				 		mRender: function(data, type, row){
				 			return '<img src="'+window.contextRoot+'/resources/images/'+data+'.png" width="100" height="100"/>';
				 		}
				 	},
			     	{data: 'name'},
			        {data: 'brand'},
			        {data: 'unitPrice',
			        	mRender: function(data, type, row){
			        		return 'Fcfa ' +data
			        	}
			        },
			        {data: 'quantity',
			        	mRender: function(data, type, row){
			        		if (data < 1){
			        			return '<span style="color:red;"><b>Out of Stock</b></span>'
			        		}
			        		return data
			        	}
			        },
			        {data: 'id',
			        	bSortable: false,
			        	mRender: function(data, type, row){
			        		var str = '';
			        		if (userRole == 'ADMIN'){
		        				str += '<a href="'+window.contextRoot+ '/manage/'+data+'/product" title="Edit Product"><span class="glyphicon glyphicon-pencil btn btn-success"></span></a>';
		        			} else {
		        				str += '<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160';
		        				if (row.quantity < 1) {
				        			str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
				        		} else {
				        			str += '<a href="'+window.contextRoot+ '/cart/add/'+data+'/product"><span class="glyphicon glyphicon-shopping-cart btn btn-success"></span></a>';
				        		}
		        			}
			        		return str;
			        	}
			        }
			    ]
		});
	}
	
	//Code for Show message validation after 3s
	var $alertMessage = $('.alert');
	if ($alertMessage.length){
		setTimeout(function(){
			$alertMessage.fadeOut('slow');
		}, 3000)
	}
	
	//Code for BootBox Management Products
	$('.switch input[type="checkbox"]').on('change', function(){
		var checkbox = $(this);
		var valueChecked = checkbox.prop('checked');
		var msg = (valueChecked) ? 'Are you sure you want to deactivate this Product' : 'Are you sure you want to activate this Product';
		var value = checkbox.prop('value');
		
		bootbox.confirm({
			size: 'medium',
			title: '<b>Product Activation and Deactivation</b>',
			message: msg,
			callback: function(confirmed){
				if (confirmed){
					console.log(value);
					bootbox.alert({
						size: 'medium',
						title: '<b>Confirmation Informations</b>',
						message: 'You are goint to perform the activation product'
					});
				} else {
					checkbox.prop('checked', !valueChecked);
				}
			}
		});
	});
	
	//Code for Admin DataTable fetch Data Json: url='/json/data/admin/all/products'
	var $adminTable = $('#adminProductsTable');
		
		if ($adminTable.length){
			console.log('Inside the table Admin Datatables ...');
			var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
			
			$adminTable.DataTable({
				lengthMenu: [[10,20,30,-1], ['10 Products', '20 Products', '30 Products', 'All Products']],
				pageLength: 10,
				ajax: {
					url: jsonUrl,
					dataSrc: ''
				},
				columns: 
					[
						{data: 'id'},
					 	{data: 'code',
							bSortable: false,
					 		mRender: function(data, type, row){
					 			return '<img src="'+window.contextRoot+'/resources/images/'+data+'.png" width="100" height="100"/>';
					 		}
					 	},
				     	{data: 'name'},
				     	{data: 'brand'},
				     	{data: 'quantity',
				        	mRender: function(data, type, row){
				        		if (data < 1){
				        			return '<span style="color:red;"><b>Out of Stock</b></span>'
				        		}
				        		return data
				        	}
				        },
				        {data: 'unitPrice',
				        	mRender: function(data, type, row){
				        		return 'Fcfa ' +data
				        	}
				        },
				        {data: 'active',
				        	bSortable: false,
				        	mRender: function(data, type, row){
				        		var str = '';
				        		str += '<label class="switch">';
				        		
				        		if (data){
				        			str += '<input type="checkbox" checked="checked" value="'+row.id+'" />';
				        		} else {
				        			str += '<input type="checkbox" value="'+row.id+'" />';
				        		}
								str +=	'<div class="slider"></div></label>';
								
								return str;
				        	}
				        },
				        {data: 'id',
				        	bSortable: false,
				        	mRender: function(data, type, row){
				        		var str = '';
				        		str += '<a href="'+contextRoot+'/manage/'+data+'/product" title="Edit Product" class="btn btn-danger">';
				        		str += '<span class="glyphicon glyphicon-pencil"></span></a>';
				        		return str;
				        	}
				        }
				    ],
				    initComplete: function(){
				    	var showSwitch = this.api();
				    	showSwitch.$('.switch input[type="checkbox"]').on('change', function(){
				    		var checkbox = $(this);
				    		var valueChecked = checkbox.prop('checked');
				    		var msg = (valueChecked) ? 'Are you sure you want to activate this Product' : 'Are you sure you want to deactivate this Product';
				    		var value = checkbox.prop('value');
				    		
				    		bootbox.confirm({
				    			size: 'medium',
				    			title: '<b>Product Activation and Deactivation</b>',
				    			message: msg,
				    			callback: function(confirmed){
				    				if (confirmed){
				    					console.log(value);
				    					
				    					var actionUrl = window.contextRoot + '/manage/product/' +value+ '/action';
				    					$.post(actionUrl, function(data){
				    						bootbox.alert({
					    						size: 'medium',
					    						title: '<b>Confirmation Informations</b>',
					    						message: data
					    					});
				    					});
				    				} else {
				    					checkbox.prop('checked', !valueChecked);
				    				}
				    			}
				    		});
				    	});
				    }
			});
		}
	
	//Code Validation Categoey Form
	var catForm = $('#categoryForm');
	if (catForm.length){
		catForm.validate({
			rules: {
				name: {
					required: true,
					minLength: 2
				},
				description: {
					required: true,
					minLength: 2
				}
			},
			messages: {
				name: {
					required: 'Please enter the category name',
					minLength: 'The category name shoud not be less than 2 characters'
				},
				description: {
					required: 'Please enter the category description'
				}
			},
			errorElement: 'em',
			errorPlacement: function(error, element){
				error.addClass('help-block');
				error.insertAfter(element);
			}
		});
	}
	
	//Code Validation login Form
	var loginForm = $('#loginForm');
	if (loginForm.length){
		loginForm.validate({
			rules: {
				username: {
					required: true,
					email: true
				},
				password: {
					required: true,
				}
			},
			messages: {
				username: {
					required: 'Please enter username',
					email: 'Please enter the valid email address'
				},
				password: {
					required: 'Please enter password'
				}
			},
			errorElement: 'em',
			errorPlacement: function(error, element){
				error.addClass('help-block');
				error.insertAfter(element);
			}
		});
	}
	
	//Refresh items into the cart
	$('button[name="cartRefresh"]').click(function(){
		var idCart = $(this).attr('value');
		var countElement = $('#count_' +idCart);
		
		var originalCount = countElement.attr('value');
		var currentCount = countElement.val();
		
		if (currentCount !== originalCount){
			console.log("currentCount: " +currentCount);
			console.log("originalCount: " +originalCount);
			if (currentCount < 1 || currentCount > 3) {
				countElement.val(originalCount);
				bootbox.alert({
					size: 'medium',
					title: '<b>Update Quantity Product Error</b>',
					message: 'Product quantity should be minimum 1 and maximum 3'
				});
			} else {
				var urlToUpdate = window.contextRoot + '/cart/' +idCart+ '/update?count=' +currentCount;
				window.location.href = urlToUpdate;
			}
		}
	});
	
	//Profile user Section
	 $("div.bhoechie-tab-menu>div.list-group>a").click(function(e) {
	        e.preventDefault();
	        $(this).siblings('a.active').removeClass("active");
	        $(this).addClass("active");
	        var index = $(this).index();
	        console.log("index ...." +index);
	        $("div.bhoechie-tab>div.bhoechie-tab-content").removeClass("active");
	        $("div.bhoechie-tab>div.bhoechie-tab-content").eq(index).addClass("active");
	    });

	 
	 //
	 function startTime() {
		 var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
		 var days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
		     var today = new Date();
		     var h = today.getHours();
		     var m = today.getMinutes();
		     var s = today.getSeconds();
		     var d = today.getDay();
		     var y = today.getFullYear();
		     var month = months[today.getMonth()];
		     var day = days[today.getDay()];
		     m = checkTime(m);
		     s = checkTime(s);
		     var counterTime = day+ ", " +d+ " "+month+ " " +y+ " - "+h+ ":" +m+ ":" +s;
		     document.getElementById('time').innerHTML = counterTime;
		     var t = setTimeout(startTime, 500);
		     console.log("current time: " +counterTime);
		 }
		 function checkTime(i) {
		     if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
		     return i;
		 }
	 
	 //
});