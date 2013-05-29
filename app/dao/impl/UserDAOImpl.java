package dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import dao.UserDAO;
import dao.entity.User;
import org.hibernate.SessionFactory;

@Repository
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<User> find() {
		return getHibernateTemplate().find("from User");
	}

	@Override
	public void add(User u) {
		getHibernateTemplate().save(u);
	}
	
	@Override
	public void delete(Long id) {
		getHibernateTemplate().bulkUpdate("delete from User where id = ?", new Object[]{id});
	}
}
