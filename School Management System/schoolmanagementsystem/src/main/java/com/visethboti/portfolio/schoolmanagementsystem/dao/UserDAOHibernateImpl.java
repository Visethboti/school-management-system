package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.visethboti.portfolio.schoolmanagementsystem.entity.User;

@Repository
public class UserDAOHibernateImpl implements UserDAO {

	// define field for entitymanager
	
	private EntityManager entityManager;
	
	// set up constructor injection
	
	@Autowired
	public UserDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<User> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<User> theQuery =
				currentSession.createQuery("from User", User.class);
		
		// execute query and get result list
		List<User> users = theQuery.getResultList();
		
		// return the results
		return users;
	}

	@Override
	public User findById(int theUserID) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the User
		User theUser = currentSession.get(User.class, theUserID);
		
		// return the User
		return theUser;
	}

	@Override
	public void save(User theUser) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save User
		currentSession.saveOrUpdate(theUser); // if id=0 then save/insert, else update
	}

	@Override
	public void deleteById(int theUserID) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query theQuery =currentSession.createQuery("delete from User where id=:UserID");
		theQuery.setParameter("UserID", theUserID);
		
		theQuery.executeUpdate();
		
	}
}
