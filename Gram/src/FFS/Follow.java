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
import java.util.Map.Entry;
import java.util.Set;

public class Follow {
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

	public Map<String, Set<String>> createFollow() {
		HashMap<String, String> productMap = product.getMap();
		List<String> endList = endCode.getCodeList();
		List<String> notEndList = notEndCode.getCodeList();
		List<String> beginList = beginCode.getCodeList();
		Map<String, Set<String>> firstMap = new First().getFirst();
		Map<String, Set<String>> followMap = new HashMap<String, Set<String>>();
		for (String str : notEndList) {
			Set<String> set = new HashSet<String>();
			if(beginList.contains(str)) set.add("#");
			followMap.put(str, set);
		}
		boolean changed = true;
		while (changed) {
			changed = false;
			for (Map.Entry<String, String> map : productMap.entrySet()) {
				for (String str : map.getValue().split("\\|")) {
					int len = str.length();
					if (len >= 3 && notEndList.contains(str.substring(len - 2, len - 1))) {
						Set<String> first = firstMap.get(str.substring(len - 1));
						Set<String> set = followMap.get(str.substring(len - 2, len - 1));
						for (String f : first) {
							if (!set.contains(f) && !f.equals("$")) {
								set.add(f);
								changed = true;
							}
							followMap.put(str.substring(len - 2, len - 1), set);
							if (first.contains("$")) {
								for (String fs : followMap.get(map.getKey())) {
									if (!set.contains(fs)) {
										set.add(fs);
										changed = true;
									}
								}
							}
							followMap.put(str.substring(len - 2, len - 1), set);
						}

					}
					if (len == 2 && notEndList.contains(str.substring(len - 1))) {
						Set<String> fset = followMap.get(str.substring(len - 1));
						for (String fs : followMap.get(map.getKey())) {
							if (!fset.contains(fs)) {
								fset.add(fs);
								changed = true;
							}

						}
						followMap.put(str.substring(len - 1), fset);
					}

				}

			}
		}
		return followMap;
	}

	public Map<String, Set<String>> getFollow() {
		Follow follow = new Follow();
		follow.getData();
		Map<String, Set<String>> followMap = follow.createFollow();
		return followMap;
	}

	public void printFollow() {
		Follow follow = new Follow();
		Map<String, Set<String>> followMap = follow.getFollow();
		for (Map.Entry<String, Set<String>> entry : followMap.entrySet()) {
			System.out.println("Follow(" + entry.getKey() + ")=" + entry.getValue());
		}
	}
	public static void main(String[] args) {
		new First().printFirst();
		new Follow().printFollow();
	}
}
