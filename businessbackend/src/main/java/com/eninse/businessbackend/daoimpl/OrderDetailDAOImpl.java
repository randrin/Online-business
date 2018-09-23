package com.eninse.businessbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eninse.businessbackend.dao.OrderDetailDAO;
import com.eninse.businessbackend.dto.OrderDetail;

@Repository("orderDetailDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO {

	public static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * Add orders Detail in H2 Database
	 */
	@Override
	public boolean addOrderDetail(OrderDetail orderDetail) {
		try {
			sessionFactory
				.getCurrentSession()
					.persist(orderDetail);
			return true;
		} catch (Exception e) {
			log.error("Error trying to add orderDetail, " + e.getMessage() + " - "
					+ e.getCause());
			return false;
		}
	}

}
