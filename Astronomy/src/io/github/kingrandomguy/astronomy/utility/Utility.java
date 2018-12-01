package io.github.kingrandomguy.astronomy.utility;

import java.util.StringTokenizer;

public class Utility {
	/**
	 * Makes a "proper" name (turns LIGHT_YEAR to Light Year)
	 * @param name
	 * @return
	 */
	public static String properName(String name) {
		StringTokenizer st = new StringTokenizer(name.replace('_', ' '));
		String rtn = "";
		while(st.hasMoreTokens()) {
			String sub = st.nextToken();
			if(sub.length()>1) {
				String firstPart = sub.substring(0, 1);
				String secondPart = sub.substring(1);
				rtn+=firstPart.toUpperCase() + secondPart.toLowerCase();
			}
			else {
				rtn+=sub.toUpperCase();
			}
			if(st.hasMoreTokens()) {
				rtn+=' ';
			}
		}
		return rtn;
	}
}
