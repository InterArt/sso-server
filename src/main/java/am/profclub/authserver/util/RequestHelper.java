package am.profclub.authserver.util;

/**
 * Created by admin on 6/5/17.
 */
public class RequestHelper {

	public static String getCustomerDomain(String host) {
		if (host == null) return null;

		int index = host.indexOf(".");
		return (index != -1 ? host.substring(0, index) : host);
	}

	public static void main(String[] args) {
		System.out.println(getCustomerDomain("artstormsso.attask-ondemand.com"));
	}
}
