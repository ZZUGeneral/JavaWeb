package FFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PridectTable {
	public static void main(String[] args) {
		Select select = new Select();
		select.getData();
		Map<String, String> selectMap = new PridectTable().changeSelect();
		Map<String, Set<String>> followMap = new Follow().getFollow();
		Map<String, Set<String>> firstMap = new First().getFirst();
		List<String> endList = select.endCode.getCodeList();
		List<String> notEndList = select.notEndCode.getCodeList();
		List<String> beginList = select.beginCode.getCodeList();
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		List<String> strList1 = new ArrayList<String>();
		List<String> strList2 = new ArrayList<String>();
		strList2.add("#");
		for (int i = str.length(); i > 0; i--) {
			strList1.add(str.substring(i - 1, i));
		}
		for (String s : beginList)
			strList2.add(s);
		boolean flag = true;
		int len1 = strList1.size(), len2 = strList2.size();
		String s1 = strList1.get(len1 - 1), s2 = strList2.get(len2 - 1);
		len1--;
		len2--;
		while (flag) {
			System.out.println(s2.concat(s1) + "   " + selectMap.get(s2.concat(s1)));
			System.out.println(strList1 + "             " + strList2);
			if (endList.contains(s2)) {
				if (s1.equals(s2)) {
					strList1.remove(len1);
					strList2.remove(len2);
					s1 = strList1.get(len1 - 1);
					s2 = strList2.get(len2 - 1);
					len1--;
					len2--;
				} else if (s2.equals("$")) {
					strList2.remove(len2);
					s2 = strList2.get(len2 - 1);
					len2--;
				} else {
					System.out.println("Error1");
					break;
				}
			} else if (s2 == "#") {
				if (s1.equals(s2))
					flag = false;
				else {
					System.out.println("Error2");
					break;
				}
			} else {
				String value = selectMap.get(s2.concat(s1)) == null ? null : selectMap.get(s2.concat(s1));
				if (value != null) {
					value = value.split("->")[1];
					strList2.remove(len2);
					for (int i = value.length() - 1; i >= 0; i--) {
						strList2.add(value.substring(i, i + 1));
					}
					len2 = strList2.size();
					s2 = strList2.get(len2 - 1);
					len2--;
				} else if (firstMap.get(s2).contains("$")) {
					strList2.remove(len2);
					s2 = strList2.get(len2 - 1);
					len2--;
				} else {
					System.out.println("Error3");
					break;
				}
			}
		}
		if (flag)
			System.out.println("匹配失败！！！");
		else
			System.out.println("匹配成功！！！");
	}

	public Map<String, String> changeSelect() {
		Map<String, Set<String>> selectMap = new Select().getSelect();
		Map<String, String> change = new HashMap<String, String>();
		for (Map.Entry<String, Set<String>> map : selectMap.entrySet()) {
			Set<String> set = map.getValue();
			String str = map.getKey();
			String kv1 = str.substring(0, 1);
			for (String s : set) {
				if (!s.equals("$")) {
					String kv = kv1.concat(s);
					change.put(kv, str);
				}
			}
		}
		/*
		 * for (Entry<String, String> map : change.entrySet()) {
		 * System.out.println(map.getKey() + "   " + map.getValue()); }
		 */
		return change;
	}
}
