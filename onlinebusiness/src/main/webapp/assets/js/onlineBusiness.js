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
			        			console.log('Inside data quantity ...');
			        			console.log('data quantity ...: ' +data);
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
			        			console.log('Inside data id ...');
			        			console.log('row.quantity ...: ' +row.quantity);
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
});