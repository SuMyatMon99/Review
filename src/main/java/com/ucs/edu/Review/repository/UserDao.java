package com.ucs.edu.Review.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucs.edu.Review.model.LoginUser;
import com.ucs.edu.Review.model.UserRole;
@Repository
public class UserDao implements IUserDao{
	@Autowired
	SessionFactory sessionFactory;
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	public LoginUser findUserByUserName(String name) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(LoginUser.class)
				.createAlias("userRole","r",JoinType.LEFT_OUTER_JOIN)
				.createAlias("r.privilegesList", "p",JoinType.LEFT_OUTER_JOIN);
		
		c.add(Restrictions.eq("userName", name));	
		LoginUser user = (LoginUser) c.uniqueResult();	
		return user;
	}
	public void saveUser(LoginUser user) {
		// TODO Auto-generated method stub
		getCurrentSession().save(user);
		
	}
	public List<UserRole> getUserRoles() {
		// TODO Auto-generated method stub
		return getCurrentSession().createCriteria(UserRole.class).list();
	}

}
