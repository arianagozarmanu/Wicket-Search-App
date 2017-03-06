package wicket.helloworld;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class HelloWorld extends WebPage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelloWorld() {
		
		add(new Label("page-title", "Hello World, Wicket"));

		RepeatingView listItems = new RepeatingView("list-item");
		add(listItems);
		
		for(int i = 0; i < 10 ; i++) {
			Utility.addLinkListItems(listItems);
		}
		
		 // Get the Java runtime
	    Runtime runtime = Runtime.getRuntime();
	    // Run the garbage collector
	    runtime.gc();
	    // Calculate the used memory
	    long memory = runtime.totalMemory() - runtime.freeMemory();
	    System.out.println("Used memory is bytes: " + memory);
	    System.out.println("Used memory is megabytes: "
	        + Utility.bytesToMegabytes(memory));
		

	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
	    response.render(CssHeaderItem.forReference(new CssResourceReference(HelloWorld.class, "/css/helloworld-page-style.css")));
	    response.render(JavaScriptReferenceHeaderItem.forReference( new JavaScriptResourceReference(HelloWorld.class, "/js/search-logic.js")));
	}
	

}
