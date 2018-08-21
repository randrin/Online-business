package com.eninse.businessbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eninse.businessbackend.dao.CartLineDAO;
import com.eninse.businessbackend.dto.Cart;
import com.eninse.businessbackend.dto.CartLine;

@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImpl implements CartLineDAO {

	public static final Logger log = LoggerFactory.getLogger(CartLineDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * Get List Cartline identify by cardId in H2 Database
	 */
	@Override
	public List<CartLine> list(int cartId) {
		String cartLineList = "FROM CartLine WHERE cartId = :cartId";
			
			return sessionFactory
					.getCurrentSession()
						.createQuery(cartLineList, CartLine.class)
							.setParameter("cartId", cartId)
								.getResultList();
	}

	/*
	 * Get Single Cartline in H2 Database
	 */
	@Override
	public CartLine get(int id) {
		try {
			return sessionFactory
					.getCurrentSession()
						.get(CartLine.class, Integer.valueOf(id));
		} catch(Exception e) {
			log.error("Error trying to get cartline with id= " +id+ " , " +e.getMessage()+ " - " +e.getCause());
		}
		return null;
	}

	/*
	 * Add Cartline in H2 Database
	 */
	@Override
	public boolean add(CartLine cartLine) {
		try {
			sessionFactory
					.getCurrentSession()
						.persist(cartLine);
			return true;
		} catch(Exception e) {
			log.error("Error trying to add cartline, " +e.getMessage()+ " - " +e.getCause());
			return false;
		}
	}

	/*
	 * Update Cartline in H2 Database
	 */
	@Override
	public boolean update(CartLine cartLine) {
		try {
			sessionFactory
					.getCurrentSession()
						.update(cartLine);
			return true;
		} catch(Exception e) {
			log.error("Error trying to update cartline, " +e.getMessage()+ " - " +e.getCause());
			return false;
		}
	}

	/*
	 * Delete Cartline in H2 Database
	 */
	@Override
	public boolean delete(CartLine cartLine) {
		try {
			sessionFactory
					.getCurrentSession()
						.delete(cartLine);
			return true;
		} catch(Exception e) {
			log.error("Error trying to delete cartline, " +e.getMessage()+ " - " +e.getCause());
			return false;
		}
	}

	/*
	 * Get Cart And Product identify by cartId and productId in H2 Database
	 */
	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		String cartLine = "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";
		try {
			return sessionFactory
					.getCurrentSession()
						.createQuery(cartLine, CartLine.class)
							.setParameter("cartId", cartId)
								.setParameter("productId", productId)
									.getSingleResult();
		} catch(Exception e) {
			log.error("Error trying to get cartline with cartId = "+cartId+ " "
					+ "and productId = "+productId+", " +e.getMessage()+ " - " +e.getCause());
			return null;
		}
	}

	/*
	 * Update Cartline by cart in H2 Database
	 */
	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory
					.getCurrentSession()
						.update(cart);
			return true;
		} catch(Exception e) {
			log.error("Error trying to update cartline, " +e.getMessage()+ " - " +e.getCause());
			return false;
		}
	}

	/*
	 * List Cartline availaible identify bu caetId in H2 Database
	 */
	@Override
	public List<CartLine> listCartLineAvailable(int cartId) {
		String cartLine = "FROM CartLine WHERE cartId = :cartId AND isAvailable = :isAvailable";
		try {
			return sessionFactory
					.getCurrentSession()
						.createQuery(cartLine, CartLine.class)
							.setParameter("cartId", cartId)
								.setParameter("isAvailable", true)
									.getResultList();
		} catch(Exception e) {
			log.error("Error trying to get cartline list with cartId = "+cartId+ ", " +e.getMessage()+ " - " +e.getCause());
			return null;
		}
	}

}
