package wicket.helloworld;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.PropertyModel;

public class HelloWorld extends MainPage {

	private static final CompressedResourceReference MYPAGE_JS = new CompressedResourceReference(HelloWorld.class,
			"/js/search-logic.js");
	private static final CompressedResourceReference MYPAGE_CSS = new CompressedResourceReference(HelloWorld.class,
			"/css/helloworld-page-style.css");
	
	@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
	public HelloWorld() {

		add(JavascriptPackageResource.getHeaderContribution(MYPAGE_JS));
		add(CSSPackageResource.getHeaderContribution(MYPAGE_CSS));

		 RepeatingView listItems = new RepeatingView("list-item");
		 add(listItems);
		 
		 List<String> randomStr = Utility.getListOfRandomStrings();
		 
		 for(final String s : randomStr) {
			 WebMarkupContainer list = new WebMarkupContainer(listItems.newChildId());
			 ExternalLink itemName = new ExternalLink("main-link", "#");
			 itemName.add(new Label("item-name", s));
			 list.add(itemName);
			 list.add(new Link("add-item") {
				@Override
				 public void onClick() {
					getMyCode().getMyCodes().add(s);
				 }
			 });
			 listItems.add(list);
			 
		 }
		 
		 add(new Link("remove-all") {

			@Override
			public void onClick() {
				getMyCode().getMyCodes().clear();
			}
			 
		 });
		 
		 add(new ListView("selection-list", new PropertyModel(this, "myCode.codes")) {
			@Override
			protected void populateItem(ListItem item) {
				String code = (String) item.getModelObject();
				item.add(new Label("code", code));
				item.add(new Link("remove", item.getModel()) {
					
					@Override
					public void onClick() {
						String selected = (String) getModelObject();
						getMyCode().getMyCodes().remove(selected);
					}
				});
				
			}
		 });
		 
		 add(new Label("total",  new PropertyModel(this, "myCode.getTotal")));
		 
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

		//
		
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
