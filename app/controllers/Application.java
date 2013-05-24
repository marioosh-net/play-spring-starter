package controllers;

import java.util.List;
import java.util.concurrent.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import play.data.Form;
import play.libs.Akka;
import play.libs.F.Function;
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
		
		return async(Akka.future(new Callable<Object>() {

			@Override
			public Object call() throws Exception {
				return new Object[] {helloService.hello(), userDAO.find()};
			}
		}).map(new Function<Object, Result>() {

			@Override
			public Result apply(Object a) throws Throwable {
				Object[] b = (Object[]) a;
				return ok(index.render((String)b[0], (List<User>)b[1]));
			}
		}));
	}

	public Result add() {
		Form<User> userForm = Form.form(User.class);
		userForm = userForm.bindFromRequest();
		userDAO.add(userForm.get());
		return redirect("/");
	}

}
