package wicket.helloworld;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.markup.repeater.RepeatingView;

public class HelloWorld extends WebPage {
	
	private static final CompressedResourceReference MYPAGE_JS = new CompressedResourceReference(HelloWorld.class, "/js/search-logic.js"); 
	private static final CompressedResourceReference MYPAGE_CSS = new CompressedResourceReference(HelloWorld.class, "/css/helloworld-page-style.css");
	
	public HelloWorld(final PageParameters parameters) {
		
		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS));
		add(CSSPackageResource.getHeaderContribution(MYPAGE_CSS));
		
		add(new Label("page-title", "Hello World, Wicket"));

		RepeatingView listItems = new RepeatingView("list-item");
		add(listItems);
		
		for(int i = 0; i < 10 ; i++) {
			Utility.addLinkListItems(listItems);
		}
		
		
		

	}

}
