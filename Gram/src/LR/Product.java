package LR;

import java.util.ArrayList;
import java.util.List;

public class Product {

	List<String> list = new ArrayList<String>();

	public Product() {
	}

	public void addProduct(String s) {
		String[] first = s.split("->");
		String begin = first[0];
		String[] str = first[1].split("\\|");
		for (String sl : str) {
			String s2 = begin.concat("->").concat(sl);
			list.add(s2);
		}
	}

	public void write() {
		System.out.print("P={");
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("}");
	}

	public List<String> getList() {
		return list;
	}
}
