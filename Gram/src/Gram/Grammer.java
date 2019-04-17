package Gram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Grammer {

	public static void main(String[] args) {

		File file = new File("C:\\Users\\YHL\\Desktop\\Gram\\测试用例2.txt");
		EndCode endCode = new EndCode();
		NotEndCode notEndCode = new NotEndCode();
		BeginCode beginCode = new BeginCode();
		Product product = new Product();
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(reader);
			int i = Integer.parseInt(bReader.readLine());
			String[] s = bReader.readLine().split(" ");
			for (int j = 0; j < i; j++)
				endCode.addCode(s[j]);
			i = Integer.parseInt(bReader.readLine());
			s = bReader.readLine().split(" ");
			for (int j = 0; j < i; j++)
				notEndCode.addCode(s[j]);
			i = Integer.parseInt(bReader.readLine());
			s = bReader.readLine().split(" ");
			for (int j = 0; j < i; j++)
				beginCode.addCode(s[j]);
			i = Integer.parseInt(bReader.readLine());
			for (int j = 0; j < i; j++) {
				s = bReader.readLine().split("->");
				product.addProduct(s[0], s[1]);
			}
			System.out.println("G={Vt,Vn,S,P}");
			endCode.write();
			notEndCode.write();
			beginCode.write();
			product.write();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
