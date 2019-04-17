package FFS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class First {
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
			/*
			 * endCode.write(); notEndCode.write(); product.write();
			 */
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Set<String> getFirst(String str) {
		Set<String> first = new HashSet<String>();
		HashMap<String, String> map = product.getMap();
		List<String> endList = endCode.getCodeList();
		List<String> notEndList = notEndCode.getCodeList();
		int size = -1;
		while (first.size() / size != 1) {
			if (first.size() == 0)
				size = -1;
			else
				size = first.size();
			if (endList.contains(str)) {
				first.add(str);
				return first;
			}
			if (map.containsKey(str)) {
				String val = map.get(str).toString();
				String[] vStr = val.split("\\|");
				for (String s : vStr) {
					if (endList.contains(s.substring(0, 1))) {
						first.add(s.substring(0, 1));
					} else {
						Set<String> returnSet = getFirst(s.substring(0, 1));
						for (String set : returnSet)
							first.add(set);
						char[] ch = s.toCharArray();
						int flag = 0;
						for (int i = 0; i < ch.length; i++) {
							if (notEndList.contains(ch[i])) {
								if (getFirst(String.valueOf(ch[i])).contains("$")
										&& notEndList.contains(String.valueOf(ch[i])))
									continue;
								for (String set : getFirst(String.valueOf(ch[i]))) {
									if (!set.equals("$"))
										first.add(set);
								}
								flag = 1;
								break;
							}
						}
						if (flag == 0)
							first.add("$");
					}

				}
			}

		}

		return first;
	}

	public Map<String, Set<String>> first() {
		First first = new First();
		Map<String, Set<String>> firstMap = new HashMap<String, Set<String>>();
		List<String> notEndList = notEndCode.getCodeList();
		List<String> endList = endCode.getCodeList();
		first.getData();
		for (String str : notEndList) {
			firstMap.put(str, first.getFirst(str));
		}
		for (String str : endList) {
			firstMap.put(str, first.getFirst(str));
		}
		return firstMap;

	}

	public static void main(String[] args) {
		First first = new First();
		first.getData();
		Map<String, Set<String>> firstMap = first.first();
		for (Map.Entry<String, Set<String>> entry : firstMap.entrySet()) {
			System.out.println("First(" + entry.getKey() + ")=" + entry.getValue());
		}
	}

}
