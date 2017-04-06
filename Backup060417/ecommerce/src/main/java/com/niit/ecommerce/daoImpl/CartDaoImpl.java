package com.niit.ecommerce.daoImpl;

import java.io.IOException;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce.dao.CartDAO;
import com.niit.ecommerce.dao.CustomerOrderDAO;
import com.niit.ecommerce.domain.Cart;

@Repository
@Transactional
public class CartDaoImpl implements CartDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	CustomerOrderDAO customerOrderDAO;

	public Cart getCartByCartId(int cartId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Cart cart = (Cart) session.get(Cart.class, cartId);
		System.out.println(cart.getCartId() + " " + cart.getCartItems());
		session.getTransaction().commit();
		session.flush();
		session.close();
		return cart;
	}

	public Cart validate(int cartId) throws IOException {

		Cart cart = getCartByCartId(cartId);
		if (cart == null || cart.getCartItems().size() == 0) {
			throw new IOException(cartId + "");
		}

		update(cart);
		return cart;
	}

	public void update(Cart cart) {

		int cartId = cart.getCartId();
		double grandTotal = customerOrderDAO.getCustomerOrderGrandTotal(cartId);
		cart.setGrandTotal(grandTotal);

		Session session = sessionFactory.openSession();
		session.saveOrUpdate(cart);
		session.flush();
		session.close();
	}

}
