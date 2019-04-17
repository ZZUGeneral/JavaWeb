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

public class FirstTest {
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

	public Map<String, Set<String>> getFirst() {
		Set<String> first = new HashSet<String>();
		HashMap<String, String> productMap = product.getMap();
		List<String> endList = endCode.getCodeList();
		List<String> notEndList = notEndCode.getCodeList();
		Map<String, Set<String>> firstMap = new HashMap<String, Set<String>>();
		for (String str : notEndList) {
			firstMap.put(str, null);
		}
		boolean changed = true;
		while (changed) {
			for (Map.Entry<String, String> map : productMap.entrySet()) {
				if (endList.contains(map.getKey())) {
					firstMap.get(map.getKey()).add(map.getKey());
				}
				String[] str = map.getValue().split("\\|");
				for (String s : str) {
					if (endList.contains(s.substring(0, 1)))
						firstMap.get(map.getKey()).add(s.substring(0, 1));
					if (notEndList.contains(s.substring(0, 1))) {
						for (String s1 : firstMap.get(s.substring(0, 1))) {
							firstMap.get(map.getKey()).add(s1);
						}
					}
				}
			}

		}

		return firstMap;
	}

	public static void main(String[] args) {
		FirstTest first = new FirstTest();
		first.getData();
		Map<String, Set<String>> firstMap = first.getFirst();
		for (Map.Entry<String, Set<String>> entry : firstMap.entrySet()) {
			System.out.println("First(" + entry.getKey() + ")=" + entry.getValue());
		}
	}

}
