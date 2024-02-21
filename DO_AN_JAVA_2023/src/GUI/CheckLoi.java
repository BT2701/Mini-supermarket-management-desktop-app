package GUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

public class CheckLoi {
	public static boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isDouble(String input) {
		try {
			Double.parseDouble(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isBoolean(String input) {
		return "true".equalsIgnoreCase(input) || "false".equalsIgnoreCase(input);
	}

	public static boolean isValidDate(String dateStr, String formatStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
		dateFormat.setLenient(false);
		try {
			Date date = dateFormat.parse(dateStr);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	public static boolean isEmptyString(String s) {
		if(!s.equalsIgnoreCase("")) {
			return false;
		}
		return true;
		
	}
	public static boolean checkGioiTinh(String s) {
		if(!(s.equalsIgnoreCase("nam")||s.equalsIgnoreCase("nữ"))) {
			return false;
		}
		return true;
	}
	public static double similarity(String s1, String s2) {
	    HashSet<String> set1 = new HashSet<>(Arrays.asList(s1.split("")));
	    HashSet<String> set2 = new HashSet<>(Arrays.asList(s2.split("")));
	    int intersection = 0;
	    for (String s : set1) {
	        if (set2.contains(s)) {
	            intersection++;
	        }
	    }
	    return (2.0 * intersection) / (set1.size() + set2.size());
	}

}
