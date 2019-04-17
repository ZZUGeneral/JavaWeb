package FFS;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Product {
	HashMap<String, String> map = new HashMap<String, String>();

	public Product() {
	}

	public void addProduct(String s) {
		String[] str = s.split("->");
		map.put(str[0], str[1]);
	}

	public void write() {
		System.out.print("P={");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.print(entry.getKey() + "->" + entry.getValue());
			if (it.hasNext())
				System.out.print(",");
		}
		System.out.println("}");
	}

	public HashMap<String, String> getMap() {
		return map;
	}

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

}
