package wicket.helloworld;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.repeater.RepeatingView;

public final class Utility {

	private static final long MEGABYTE = 1024L * 1024L;
	 
	public static RepeatingView addLinkListItems(RepeatingView listItems) {

		for (int i = 0; i < 100; i++) {
			WebMarkupContainer list = new WebMarkupContainer(listItems.newChildId());
			ExternalLink externalLink = new ExternalLink("Link", "#");
			String element =  nextSessionId();
			externalLink.add(new Label("Text", element));
			list.add(externalLink);
			listItems.add(list);
		}
		
		return listItems;
	}

	public static List<String> getListOfRandomStrings() {
		List<String> rStrings = new ArrayList<String>();
		for (int i = 0; i < 1000; i++) {
			rStrings.add(nextSessionId());
		}
		return rStrings;
	}
	
	public static String nextSessionId() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}
	
	public static long bytesToMegabytes(long bytes) {
		    return bytes / MEGABYTE;
	}
}
