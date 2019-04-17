package Change;

import java.util.ArrayList;
import java.util.List;

public class StatusChange {
	public List<Integer> list1 = new ArrayList<Integer>();
	public List<Integer> list2 = new ArrayList<Integer>();
	public char changeCode = 'a';
	public List<Integer> getList1() {
		return list1;
	}
	public void setList1(List<Integer> list1) {
		this.list1 = list1;
	}
	public List<Integer> getList2() {
		return list2;
	}
	public void setList2(List<Integer> list2) {
		this.list2 = list2;
	}
	public char getChangeCode() {
		return changeCode;
	}
	public void setChangeCode(char changeCode) {
		this.changeCode = changeCode;
	}
	@Override
	public String toString() {
		return "StatusChange [list1=" + list1 + ", list2=" + list2 + ", changeCode=" + changeCode + "]";
	}
	
	
}
