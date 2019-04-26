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

public class Select {
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

	public Map<String, Set<String>> createSelect() {
		HashMap<String, String> productMap = product.getMap();
		List<String> endList = endCode.getCodeList();
		List<String> notEndList = notEndCode.getCodeList();
		Map<String, Set<String>> followMap = new Follow().getFollow();
		Map<String, Set<String>> firstMap = new First().getFirst();
		Map<String, Set<String>> selectMap = new HashMap<String, Set<String>>();
		for (Map.Entry<String, String> map : productMap.entrySet()) {
			for (String str : map.getValue().split("\\|")) {
				String s = map.getKey() + "->" + str;
				String key = str.substring(0, 1);
				if (firstMap.get(key).contains("$")) {
					Set<String> first = firstMap.get(key);
					Set<String> follow = followMap.get(map.getKey());
					Set<String> set = new HashSet<String>();
					for (String f : first) {
						set.add(f);
					}
					for (String f : follow) {
						set.add(f);
					}
					selectMap.put(s, set);
				} else {
					selectMap.put(s, firstMap.get(key));
				}

			}
		}
		return selectMap;
	}

	public Map<String, Set<String>> getSelect() {
		Select select = new Select();
		select.getData();
		Map<String, Set<String>> selectMap = select.createSelect();
		return selectMap;
	}
	public void printSelect() {
		Select select = new Select();
		Map<String, Set<String>> selectMap = select.getSelect();
		for (Map.Entry<String, Set<String>> entry : selectMap.entrySet()) {
			System.out.println("Select(" + entry.getKey() + ")=" + entry.getValue());
		}
	}
	public static void main(String[] args) {
		new Select().printSelect();
	}
}
