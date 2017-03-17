package wicket.helloworld;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

public class MySession extends WebSession {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MyCode code = new MyCode();
	
	protected MySession(Request request) {
		super(request);
	}
	
	public MyCode getMyCode() {
		return code;
	}

}
