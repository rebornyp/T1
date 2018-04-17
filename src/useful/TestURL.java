package useful;

import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestURL {

	public static void main(String[] args) throws Exception {
		
		/*System.out.println();
		InetAddress ip = InetAddress.getByName("www.baidu.com");
		System.out.println(ip.isReachable(3000));
		System.out.println(ip.getHostAddress());
		InetAddress local = InetAddress.getByAddress(new byte[] {127, 0, 0, 1});
		System.out.println(local.isReachable(3000));
		System.out.println(local.getHostAddress());
		System.out.println(local.getCanonicalHostName());*/
		
		String url = URLEncoder.encode("疯狂Java讲义", "utf-8");
		System.out.println(url);
		String decodeURL = URLDecoder.decode(url, "utf-8");
		System.out.println(decodeURL);
	}

}
