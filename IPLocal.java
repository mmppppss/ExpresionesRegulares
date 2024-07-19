import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPLocal {
	public static void main(String[] args) {
		String ips="8.8.8.8 203.0.113.1 198.51.100.2 172.217.16.78 93.184.216.34 192.0.2.3 192.168.43.203 151.101.1.69 104.26.10.78 13.227.73.123";
		Pattern ipLocalFormat = Pattern.compile("192.168.\\d{1,}.\\d{1,}");
		Matcher ip = ipLocalFormat.matcher(ips);
		if(ip.find())
			System.out.println("IP local identificado: "+ip.group());

	}
}
