package NFA;

import java.util.ArrayList;
import java.util.List;

public class Status {
	List<String> staList = new ArrayList<String>();

	public void addStatu(String[] statu) {
		for (String str : statu) {
			staList.add(str);
		}
	}

	public void printStatus() {
		System.out.print("S={");
		for (int i = 0; i < staList.size(); i++) {
			System.out.print(staList.get(i));
			if (i != staList.size() - 1)
				System.out.print(",");
		}
		System.out.println("}");
	}

}
