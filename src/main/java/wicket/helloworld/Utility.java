package wicket.helloworld;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.repeater.RepeatingView;

public final class Utility {

	public static void addLinkListItems(RepeatingView listItems) {

		for (int i = 0; i < 100; i++) {
			WebMarkupContainer list = new WebMarkupContainer(listItems.newChildId());
			ExternalLink externalLink = new ExternalLink("Link", "#");
			String element =  nextSessionId();
			externalLink.add(new Label("Text", element));
			list.add(externalLink);
			listItems.add(list);
		}
	}

	public static String nextSessionId() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}
}
