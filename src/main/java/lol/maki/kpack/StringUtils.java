package lol.maki.kpack;

class StringUtils {

	static String upperCamelToSnake(String s) {
		final StringBuilder ret = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			final char c = s.charAt(i);
			if (Character.isUpperCase(c)) {
				if (i > 0 && s.charAt(i - 1) != '_') {
					ret.append('_');
				}
				ret.append(Character.toLowerCase(c));
			}
			else {
				ret.append(c);
			}
		}
		return ret.toString();
	}

}
