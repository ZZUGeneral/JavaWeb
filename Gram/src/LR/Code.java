package LR;

import java.util.ArrayList;
import java.util.List;

public class Code {
	List<String> codeList = new ArrayList<String>();

	public void addCode(String s) {
		String[] str = s.split(" ");
		for (String ss : str) {
			codeList.add(ss);
		}
	}

	public void write() {

	}

	public List<String> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<String> codeList) {
		this.codeList = codeList;
	}
	
}
