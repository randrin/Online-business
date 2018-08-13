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
			
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
	
		default:
			$('#home').addClass('active');
			$('#a_'+menu).addClass('active');
			break;
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
			        		str += '<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160';
			        		
			        		if (row.quantity < 1) {
			        			str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
			        		} else {
			        			str += '<a href="'+window.contextRoot+ '/cart/add/'+data+'/product"><span class="glyphicon glyphicon-shopping-cart btn btn-success"></span></a>';
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
				        		str += '<a href="${contextRoot}/manage/'+data.id+'/product" class="btn btn-danger">';
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
	
	//
});