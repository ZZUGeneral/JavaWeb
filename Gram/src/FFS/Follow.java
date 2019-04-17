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

	public Set<String> getFollow(String str) {
		Set<String> follow = new HashSet<String>();
		HashMap<String, String> map = product.getMap();
		List<String> endList = endCode.getCodeList();
		List<String> notEndList = notEndCode.getCodeList();
		Map<String, Set<String>> firstMap = new First().first();
		int size = -1;
		while (follow.size() / size != 1) {
			if (follow.size() == 0)
				size = -1;
			else
				size = follow.size();
			if (beginCode.getCodeList().contains(str))
				follow.add("#");
			if (map.containsKey(str)) {
				String[] vStr = map.get(str).split("\\|");
				for (String s : vStr) {
					int len = s.length();
					if (len > 3 && notEndList.contains(s.substring(len - 2, len - 1))) {
						Set<String> first = firstMap.get(s.substring(len - 1));
						for (String set : first) {
							if (!set.equals("$"))
								follow.add(set);
						}
						if (first.contains("$")) {
							Set<String> fset = getFollow(s.substring(len - 2, len - 1));
							for (String fs : fset)
								follow.add(fs);
						}
					}
					if (len > 2 && notEndList.contains(s.substring(len - 1))) {
						Set<String> fset = getFollow(s.substring(len - 1));
						for (String fs : fset)
							follow.add(fs);
					}
				}

			}

		}
		return follow;
	}

	public static void main(String[] args) {

		Follow follow = new Follow();
		follow.getData();
		Set<String> returnSet = follow.getFollow("E'");
		for (String s : returnSet) {
			System.out.println(s);
		}
	}
}
