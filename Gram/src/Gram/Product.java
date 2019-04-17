package Gram;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Product {
	HashMap<String, String> map = null;

	public Product() {
		map = new HashMap<String, String>();
	}

	public void addProduct(String s1, String s2) {
		map.put(s1, s2);
	}

	public void write() {
		System.out.print("P{");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.print(entry.getKey() + "->" + entry.getValue());
			if(it.hasNext()) System.out.print(",");
		}
		System.out.println("}");
	}

}
