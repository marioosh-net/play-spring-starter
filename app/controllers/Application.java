package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import services.HelloService;
import views.html.index;
import dao.UserDAO;
import dao.entity.User;

@org.springframework.stereotype.Controller
public class Application extends Controller {

	@Autowired
	private HelloService helloService;
	
	@Autowired
	private UserDAO userDAO;
	
  	public Result index() {
    	return ok(index.render(helloService.hello(), userDAO.find()));
  	}

  	public Result add() {
  		Form<User> userForm = Form.form(User.class);
  		userForm = userForm.bindFromRequest();
  		userDAO.add(userForm.get());
  		return redirect("/");
  	}
  	
}