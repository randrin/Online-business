package com.eninse.onlinebusiness.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eninse.businessbackend.dao.CartLineDAO;
import com.eninse.businessbackend.dao.ProductDAO;
import com.eninse.businessbackend.dto.Cart;
import com.eninse.businessbackend.dto.CartLine;
import com.eninse.businessbackend.dto.Product;
import com.eninse.onlinebusiness.model.ProfileUserModel;

@Service("cartService")
public class CartService {

	private Logger log = LoggerFactory.getLogger(CartService.class);
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	 @Autowired
	 private HttpSession session;
	 
	 /*
	  * Method to retrieve items cart user logged
	  */
	 private Cart getCart(){
		 log.info("Retrieving item cart to user logged ....");
		 return ((ProfileUserModel) session.getAttribute("profileUserModel")).getCart();
	 }
	 
	public List<CartLine> getListCartLine() {
		Cart cart = this.getCart();
		return cartLineDAO.list(cart.getId());		
	}

	public String updateCartLineUser(int cartId, int count) {

		CartLine cartLine = cartLineDAO.get(cartId);

		if (cartLine == null){
			return "result=error";
		} else {
			Product p = cartLine.getProduct();
			double firstTotal = cartLine.getTotal();
			
			if(p.getQuantity() <= count) {
				count = p.getQuantity();
			}
			//Set CartLine
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(p.getUnitPrice());
			cartLine.setTotal(p.getUnitPrice() * count);
			cartLineDAO.update(cartLine);
			
			//Set Cart
			Cart cart = this.getCart();
			cart.setTotal(cart.getTotal() - firstTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			
			return "result=update";
		}
	}

	public String deleteCartLineUser(int cartId) {
		
		CartLine cartLine = cartLineDAO.get(cartId);
		
		if (cartLine == null){
			return "result=error";
		} else {
			//first update the cart
			Cart cart = this.getCart();
			cart.setTotal(cart.getTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDAO.updateCart(cart);
			
			//delete the cart
			cartLineDAO.delete(cartLine);
			
			return "result=delete";
		}
	}

	public String addCartLineUser(int productId) {

		String response = null;

		Cart cart = this.getCart();
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
		
		//check if the product isn't present in the cartLine
		if (cartLine == null){
			cartLine = new CartLine();
			
			Product prd = productDAO.get(productId);
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(prd);
			cartLine.setBuyingPrice(prd.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(prd.getUnitPrice());
			cartLine.setAvailable(true);
			cartLineDAO.add(cartLine);
			
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setTotal(cart.getTotal() + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			
			return "result=added";
			
		}
		
		return response;
	}
}
