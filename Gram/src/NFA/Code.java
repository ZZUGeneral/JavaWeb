package NFA;

import java.util.ArrayList;
import java.util.List;

public class Code {
	List<String> codeList = null;

	public Code() {
		codeList = new ArrayList<String>();
	}

	public void addCode(String[] codes) {
		for (String str : codes) {
			codeList.add(str);
		}
	}

	public void printCode() {
		System.out.print("¡Æ={");
		for (int i = 0; i < codeList.size(); i++) {
			System.out.print(codeList.get(i));
			if (i != codeList.size() - 1)
				System.out.print(",");
		}
		System.out.println("}");
	}

}
