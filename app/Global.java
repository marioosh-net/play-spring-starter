import play.*;

import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.*;
import configs.AppConfig;
import configs.DataConfig;

public class Global extends GlobalSettings {

	private ApplicationContext ctx;

	@Override
	public void onStart(Application app) {
		// ctx = new ClassPathXmlApplicationContext("components.xml");
		ctx = new AnnotationConfigApplicationContext(AppConfig.class, DataConfig.class);
	}

	@Override
	public <A> A getControllerInstance(Class<A> clazz) {
		return ctx.getBean(clazz);
	}

}