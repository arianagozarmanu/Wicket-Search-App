package wicket.helloworld;


import org.apache.wicket.markup.html.WebPage;

public abstract class MainPage extends WebPage {
	
	public MySession getMySession() {
		return (MySession) getSession();
	}
	
	public MyCode getMyCode() {
		return getMySession().getMyCode();
	}

}
