package NFA;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author YHL
 *
 */
public class ChangeFunction {
	public static List<Change> chList = new ArrayList<Change>();

	public static void addFun(int len1, String[] functions) {
		for (String str : functions) {
			char s = str.replaceAll("[0-9]", "").charAt(0);
			int index = str.indexOf(s);
			int begin = Integer.parseInt(str.substring(0, index));
			int end = Integer.parseInt(str.substring(index + 1, str.length()));
			chList.add(new Change(begin, end, s));
		}

	}

	public void printFun() {
		System.out.print("¦Ä={");
		for (Change change : chList) {
			System.out.println(change.flag1 + "-(" + change.ch + ")->" + change.flag2);
		}

		System.out.println("}");
	}

}
