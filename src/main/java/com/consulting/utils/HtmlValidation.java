package com.consulting.utils;

import org.springframework.web.util.HtmlUtils;


public class HtmlValidation {

	
	/*public static final Pattern REMOVE_TAGS = Pattern.compile("<.+?>");

	public static String removeTags(String string) {
		if (string.isEmpty()) {
			return string;
		}
		Matcher m = REMOVE_TAGS.matcher(string);
		return m.replaceAll("");
	}*/
	public static boolean isHtml(String input) {
        boolean isHtml = false;
        if (input != null) {
            if (!input.equals(HtmlUtils.htmlEscape(input))) {
                isHtml = true;
            }
        }
        return isHtml;
    }
}
