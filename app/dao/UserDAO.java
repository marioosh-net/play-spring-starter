package dao;

import java.util.List;
import dao.entity.User;


public interface UserDAO {
	public void add(User u);
	public List<User> find();
}
