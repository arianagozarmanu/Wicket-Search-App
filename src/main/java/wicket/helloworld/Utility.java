package wicket.helloworld;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public final class Utility {

	private static final long MEGABYTE = 1024L * 1024L;

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
