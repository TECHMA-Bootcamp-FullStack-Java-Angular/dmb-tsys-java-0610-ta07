package utils;

public class Utils {

	public static String hr() {
		return "************************************************************";
	}

	public static String orange(String text) {
		return "\033[33m" + text + "\u001B[0m";
	}

	public static String green(String text) {
		return "\033[32m" + text + "\u001B[0m";
	}

	public static String blue(String text) {
		return "\033[34m" + text + "\u001B[0m";
	}

	public static String cian(String text) {
		return "\033[36m" + text + "\u001B[0m";
	}

	public static String red(String text) {
		return "\033[35m" + text + "\u001B[0m";
	}
}