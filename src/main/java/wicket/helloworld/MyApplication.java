package wicket.helloworld;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;

public class MyApplication extends WebApplication {
	
	public MyApplication() {	
	}
	
	@Override
	protected void init() {
	}
	
	public static MyApplication get() {
		return (MyApplication) Application.get();
	}
	
	@Override
	public Class<? extends Page> getHomePage() {
		return HelloWorld.class; // return default page
	}
	
	@Override
	public Session newSession(Request request, Response response) {
		return new MySession(request);
	}

}
