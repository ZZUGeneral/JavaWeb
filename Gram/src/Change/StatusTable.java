package Change;

import java.util.ArrayList;
import java.util.List;

import NFA.Change;
import NFA.ChangeFunction;

public class StatusTable {
	List<Change> chList = new ArrayList<Change>();

	public void makeStatusTable(char[][] str) {
		List<StatusChange> scList = new ArrayList<StatusChange>();
		StatusChange sc = new StatusChange();
		String[] s = "0*5 5a5 5b5 5*1 1a3 3a2 4b1 4b2 2*6 6a6 6b6 6*7".split(" ");
		ChangeFunction cf = new ChangeFunction();
		cf.addFun(s.length, s);
		chList = cf.chList;
		sc.list1.add(0);
		sc.changeCode = 'a';
		sc.list2 = getList(sc.list1, sc.changeCode, 0);
		for (Integer ts : sc.list2)
			System.out.println(ts);
	}

	public List<Integer> getList(List<Integer> list1, char ch, int flag) {
		List<Integer> intList = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();
		for (Integer statu : list1) {
			for (Change change : chList) {
				if (change.flag1 == statu) {
					if (change.ch == '*' || change.ch == ch) {
						resList.add(change.flag2);
						if (change.ch == '*')
							intList.add(change.flag2);
					}
				}
			}
		}

		for (Integer i : intList)
			System.out.println(i + "   ");
		List<Integer> list = getList(intList, ch, flag);
		for (Integer i : list) {
			if (!resList.contains(i))
				resList.add(i);
		}

		return resList;

	}

	public static void main(String[] args) {
		StatusTable st = new StatusTable();
		st.makeStatusTable(null);
	}

}
