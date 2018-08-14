package com.eninse.businessbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eninse.businessbackend.dao.UserDAO;
import com.eninse.businessbackend.dto.Address;
import com.eninse.businessbackend.dto.Cart;
import com.eninse.businessbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	public static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * Add new user in H2 Database
	 */
	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			log.error("Error trying to add user, " + e.getMessage() + " - "
					+ e.getCause());
			return false;
		}
	}

	/*
	 * Add new Address in H2 Database
	 */
	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			log.error("Error trying to add address, " + e.getMessage() + " - "
					+ e.getCause());
			return false;
		}
	}

	/*
	 * Add new Cart in H2 Database
	 */
	@Override
	public boolean addCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		} catch (Exception e) {
			log.error("Error trying to add cart, " + e.getMessage() + " - "
					+ e.getCause());
			return false;
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND billing = :billing";

		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
					.setParameter("user", "user")
					.setParameter("billing", "billing")
					.getSingleResult();
		} catch (Exception e) {
			log.error("Error trying to get Address for the user id = "
					+ user.getId() + ", " + e.getMessage() + " - "
					+ e.getCause());
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddress(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND shipping = :shipping";

		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
					.setParameter("user", "user")
					.setParameter("shipping", "shipping")
					.getResultList();
		} catch (Exception e) {
			log.error("Error trying to get Address for the user id = "
					+ user.getId() + ", " + e.getMessage() + " - "
					+ e.getCause());
			return null;
		}
	}

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :emailAddress";
		
		log.info("Email Adress user : " +email);
		
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, User.class)
					.setParameter("emailAddress", email)
					.getSingleResult();
		} catch (Exception e) {
			log.error("Error trying to get User with email = "
					+ email + ", " + e.getMessage() + " - "
					+ e.getCause());
			return null;
		}
	}

}
