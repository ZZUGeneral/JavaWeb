package LR;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClosureMap {
	public EndCode endCode = new EndCode();
	public NotEndCode notEndCode = new NotEndCode();
	public Product product = new Product();
	public BeginCode beginCode = new BeginCode();

	public void getData() {
		File file = new File("C:\\Users\\YHL\\Desktop\\test.txt");
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(reader);
			String s = bReader.readLine();
			endCode.addCode(s);
			s = bReader.readLine();
			notEndCode.addCode(s);
			s = bReader.readLine();
			beginCode.addCode(s);
			while ((s = bReader.readLine()) != null) {
				product.addProduct(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String insertString(String s1) {
		int index = s1.indexOf("_");
		String str = null;
		if (index == -1) {
			StringBuilder sb = new StringBuilder(s1);
			sb.insert(3, "_");
			str = sb.toString();
		} else if (index == s1.length() - 1) {
			return s1;
		} else {
			StringBuilder sb = new StringBuilder(s1);
			sb.replace(index, index + 1, "");
			sb.insert(index + 1, "_");
			str = sb.toString();
		}
		return str;

	}

	public String getString(String str) {
		int index = str.indexOf("_");
		String s = null;
		if (index <= str.length() - 2) {
			s = str.substring(index + 1, index + 2);
		} else {
			s = str;
		}
		return s;

	}

	public List<String> getList(String str) {
		List<String> productList = product.getList();
		List<String> list = new ArrayList<String>();
		for (String str1 : productList) {
			if (str1.startsWith(str))
				list.add(insertString(str1));
		}
		return list;
	}

	public Map<String, Integer> Table() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int count = 1;
		for (String str : endCode.getCodeList()) {
			map.put(str, count);
			count++;
		}
		for (String str : notEndCode.getCodeList()) {
			map.put(str, count);
			count++;
		}
		return map;
	}

	public void getClosure() {
		List<String> productList = product.getList();
		List<String> end = endCode.getCodeList();
		Map<String, Integer> tableMap = Table();
		Map<Integer, Closure> map = new HashMap<Integer, Closure>();
		map.put(0, new Closure(0, 0, "&", getList("S")));
		boolean change = true;
		while (change) {
			change = false;
			for (Closure clo : map.values()) {
				System.out.println(clo.toString());
				List<String> temp = new ArrayList<String>();
				for (String str : clo.getList())
					temp.add(str);
				for (String str : clo.getList()) {
					String ss = getString(str);
					if (!end.contains(ss)) {
						for (String s : getList(ss)) {
							if (!temp.contains(s)) {
								temp.add(s);
								change = true;
							}
						}
					}
					int to = clo.getTo() + tableMap.get(ss);
					if (map.get(to) == null) {
						List<String> sList = new ArrayList<String>();
						sList.add(insertString(str));
						map.put(to, new Closure(clo.getTo(), to, ss, sList));
						change = true;
						break;
					}
				}
				clo.setList(temp);
			}
		}
		for (Map.Entry<Integer, Closure> m : map.entrySet()) {
			System.out.println(m.getKey() + " : " + m.getValue());
		}

	}

	public static void main(String[] args) {
		ClosureMap c = new ClosureMap();
		c.getData();
		c.getClosure();
	}
}
