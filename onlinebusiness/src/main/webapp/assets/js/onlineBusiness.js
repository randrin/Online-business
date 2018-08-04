$(document).ready(function() {

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
		$('#listOfProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
});