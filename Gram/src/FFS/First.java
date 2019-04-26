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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Map<String, Set<String>> createFirst() {
		Map<String, String> productMap = product.getMap();
		List<String> endList = endCode.getCodeList();
		List<String> notEndList = notEndCode.getCodeList();
		Map<String, Set<String>> firstMap = new HashMap<String, Set<String>>();
		for (String str : notEndList) {
			Set<String> set = new HashSet<String>();
			firstMap.put(str, set);
		}
		for (String s : endList) {
			Set<String> set = new HashSet<String>();
			set.add(s);
			firstMap.put(s, set);
		}
		boolean changed = true;
		while (changed) {
			changed = false;
			for (Map.Entry<String, String> map : productMap.entrySet()) {
				String[] str = map.getValue().split("\\|");
				for (String s : str) {
					if (endList.contains(s.substring(0, 1))) {
						Set<String> set = firstMap.get(map.getKey());
						if (!set.contains(s.substring(0, 1))) {
							set.add(s.substring(0, 1));
							changed = true;
							firstMap.put(map.getKey(), set);
						}
					}
					if (notEndList.contains(s.substring(0, 1))) {
						Set<String> set = firstMap.get(map.getKey());
						for (String s1 : firstMap.get(s.substring(0, 1))) {
							if (s1 != "$" && !set.contains(s1)) {
								set.add(s1);
								changed = true;
							}
						}
						firstMap.put(map.getKey(), set);
					}
					int index = 0;
					for (int i = 1; i < s.length(); i++) {
						if (!productMap.containsKey(s.substring(i - 1, i))
								|| !(productMap.get(s.substring(i - 1, i)).contains("$"))) {
							index = i;
							break;
						}
					}
					if (index == 0) {
						Set<String> set = firstMap.get(map.getKey());
						if (!set.contains("$") && !s.contains(s.substring(0, 1))) {
							set.add("$");
							changed = true;
							firstMap.put(map.getKey(), set);
						}
					} else if (index != 1) {
						Set<String> set = firstMap.get(map.getKey());
						if (endList.contains(s.substring(index - 1, index))) {
							if (!set.contains(s.substring(index - 1, index))) {
								set.add(s.substring(index - 1, index));
								changed = true;
							}
						} else {
							for (String s1 : firstMap.get(s.substring(index - 1, index))) {
								if (s1 != "$" && !set.contains(s1)) {
									set.add(s1);
									changed = true;
								}
							}

						}
						firstMap.put(map.getKey(), set);
					}

				}
			}

		}

		return firstMap;
	}

	public Map<String, Set<String>> getFirst() {
		First first = new First();
		first.getData();
		Map<String, Set<String>> firstMap = first.createFirst();
		for (String s : endCode.codeList) {
			Set<String> set = new HashSet<String>();
			set.add(s);
			firstMap.put(s, set);
		}
		return firstMap;

	}

	public void printFirst() {
		First first = new First();
		Map<String, Set<String>> firstMap = first.getFirst();
		for (Map.Entry<String, Set<String>> entry : firstMap.entrySet()) {
				System.out.println("First(" + entry.getKey() + ")=" + entry.getValue());
		}
	}

	public static void main(String[] args) {
		new First().printFirst();
	}

}
