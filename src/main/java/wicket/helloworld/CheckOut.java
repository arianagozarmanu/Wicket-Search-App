package wicket.helloworld;

import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.model.PropertyModel;

public class CheckOut extends MainPage {
	
	private static final CompressedResourceReference MYPAGE_CSS = new CompressedResourceReference(HelloWorld.class,
			"/css/checkout-page-style.css");
	
	@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
	public CheckOut() {
		
		add(CSSPackageResource.getHeaderContribution(MYPAGE_CSS));
		
		Form form = new Form("form");
		add(form);
		
		Address address = getMyCode().getBillingAddress();
		
		form.add(new TextField("name", new PropertyModel(address, "name")));
		form.add(new TextField("street", new PropertyModel(address, "street")));
		form.add(new TextField("zipcode", new PropertyModel(address, "zipcode")));
		form.add(new TextField("city", new PropertyModel(address, "city")));
		
		form.add(new Link("cancel") {

			@Override
			public void onClick() {
				setResponsePage(HelloWorld.class);
			}
			
		});
		
		form.add(new Button("order") {
			@Override 
			public void onSubmit() {
				MyCode code = getMyCode();
				code.getMyCodes().clear();
				setResponsePage(HelloWorld.class);
			}
		});
	}

}
