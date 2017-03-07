package wicket.helloworld;

import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.markup.repeater.RepeatingView;

public class HelloWorld extends WebPage {

	private static final CompressedResourceReference MYPAGE_JS = new CompressedResourceReference(HelloWorld.class,
			"/js/search-logic.js");
	private static final CompressedResourceReference MYPAGE_CSS = new CompressedResourceReference(HelloWorld.class,
			"/css/helloworld-page-style.css");

	public HelloWorld(final PageParameters parameters) {

		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS));
		add(CSSPackageResource.getHeaderContribution(MYPAGE_CSS));

		add(new Label("page-title", "Hello World, Wicket"));

		
		 RepeatingView listItems = new RepeatingView("list-item");
		 add(listItems);
		 
		 for(int i = 0; i < 10 ; i++) { 
			 listItems = Utility.addLinkListItems(listItems);
		 }
		 
		 //paginare
/*		    List<String> friends =Utility.getListOfRandomStrings();

	        PageableListView<String> listview = new PageableListView<String>("listview", friends, 10) {
				private static final long serialVersionUID = 1L;

				protected void populateItem(ListItem<String> item) {
	                item.add(new Label("label", item.getModel().getObject().toString()));
	            }
	        };

	        add(listview);
	        add(new PagingNavigator("navigator", listview));*/


		
		// Get the Java runtime
		Runtime runtime = Runtime.getRuntime();
		// Run the garbage collector
		runtime.gc();
		// Calculate the used memory
		long memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory is bytes: " + memory);
		System.out.println("Used memory is megabytes: " + Utility.bytesToMegabytes(memory));

	}

}
