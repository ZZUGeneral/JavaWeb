package LR;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Closure {
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
			product.write();
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

	public void getClosure() {
		List<String> list1 = new ArrayList<String>();
		List<String> productList = product.getList();
		list1.add(insertString(productList.get(0)));
		boolean changed = true;
		while (changed) {
			changed = false;
			

		}

	}

	public static void main(String[] args) {
		String s = new Closure().insertString("S->E_");
		System.out.println(s);
	}
}
