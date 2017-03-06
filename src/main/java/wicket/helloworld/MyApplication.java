package wicket.helloworld;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class MyApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return HelloWorld.class; // return default page
	}

}
