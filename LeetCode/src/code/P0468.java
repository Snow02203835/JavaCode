package code;

public class P0468{
	public static void main(String[] args) {
		P0468 solution = new P0468();
		System.out.println(solution.validIPAddress("2001:0db8:85a3:00000:0:8A2E:0370:7334"));
	}
    public String validIPAddress(String IP) {
		if (IP == null || IP.length() == 0) {
			return "Neither";
		}
		int pointIndex = IP.indexOf(".");
		int colonIndex = IP.indexOf(":");
		if (pointIndex != -1 && colonIndex == -1) {
			System.out.println("Maybe IPv4");
			return verifyIPv4(IP);
		} else if (pointIndex == -1 && colonIndex != -1) {
			System.out.println("Maybe IPv6");
			return verifyIPv6(IP);
		} else {
			return "Neither";
		}
    }
	private String verifyIPv4(String ip) {
		String[] words = ip.split("\\.", -1);		
		System.out.println(ip + " " + words.length);
		if (words.length != 4) {
			return "Neither";
		}
		for (String word : words) {
			if (!validNumber(word)) {				
				System.out.println(word);
				return "Neither";
			}
		}
		return "IPv4";
	}
	private String verifyIPv6(String ip) {
		String[] words = ip.split(":", -1);
		System.out.println(ip + " " + words.length);
		if (words.length != 8) {
			return "Neither";
		}
		for (String word : words) {
			if (!validNumber16(word)) {
				return "Neither";
			}
		}
		return "IPv6";
	}
	private boolean validNumber(String num) {
		if (num == null || num.length() == 0 || num.length() > 3) {
			return false;
		}
		if (num.length() == 1) {
			return num.charAt(0) >= '0' && num.charAt(0) <= '9';
		}
		else {
			if (num.charAt(0) == '0') {
				return false;
			}
			int sums = 0;
			for (int i = 0; i < num.length(); i++) {
				if (num.charAt(i) >= '0' && num.charAt(i) <= '9') {
					sums = sums*10 + (num.charAt(i) - '0');
				} else {
					return false;
				}
			}
			return sums >= 0 && sums <= 255;
		}
	}
	private boolean validNumber16(String num) {
		if (num == null || num.length() == 0 || num.length() >= 4) {
			return false;
		}
		for (int i = 0; i < num.length(); i++) {
			char ch = num.charAt(i);
			if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}