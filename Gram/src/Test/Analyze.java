package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Analyze {
	public HashMap<Character, ArrayList<String>> experssionSet = new HashMap<Character, ArrayList<String>>();
	public ArrayList<Character> VnList = new ArrayList<Character>();// A S B 非终结符
	public ArrayList<Character> VtList = new ArrayList<Character>();// a b
	public ArrayList<Character> List = new ArrayList<Character>();// a b
	@SuppressWarnings("unchecked")
	public ArrayList<Item> stateClass[] = new ArrayList[20];
	public ArrayList<Item> items = new ArrayList<Item>();
	public ArrayList<Item> flag = new ArrayList<Item>();// 有没有被归入新一队过
	public String[][] DFA = new String[8][6];
	// public HashMap<Item, Integer> stateItem = new HashMap<Item, Integer>();
	public HashMap<Integer, ArrayList<Item>> itemClass = new HashMap<Integer, ArrayList<Item>>();
	public ArrayList<Item> stateItems = new ArrayList<Item>();
	public int totalState;

	public void closure(Item I) {
		int a;
		int b;
		ArrayList<Item> J = new ArrayList<Item>();
		ArrayList<Item> temp = new ArrayList<Item>();
		J.add(I);
		// System.out.println("\n传入的I：");
		// I.printItem();
		flag.add(I);
		if (I.getIndex() == I.getRight().length()) {
			itemClass.put(totalState, J);
			return;
		} else {
			do {
				a = J.size();
				temp.clear();
				for (Item j : J) {
					for (Item i : items) {
						if (i.getIndex() == 0 && !J.contains(i)) {
							if (j.getRight().charAt(j.getIndex()) == i.getLeft()) {
								temp.add(i);
								flag.add(i);
							}
						}
					}
				}
				J.addAll(temp);
				b = J.size();
				if (b == a) {
					itemClass.put(totalState, J);
					return;
				}
			} while (true);
		}
	}

	public String goto_fun_vt(int state, char X) {
		ArrayList<Item> I = new ArrayList<Item>();
		I = itemClass.get(state);
		int index;
		int r_count = 0;
		for (Item i : I) {
			index = i.getIndex();
			if (index < i.getRight().length()) {
				if (i.getRight().charAt(index) == X) {
					for (int count = 0; count < totalState; count++) {
						for (Item j : itemClass.get(count)) {
							if ((j.getRight().equals(i.getRight()) && j.getLeft().equals(i.getLeft()))
									&& j.getIndex() == index + 1) {
								return "s" + String.valueOf(count);
							}

						}
					}
				}
			} else {
				if (i.getRight().equals("E")) {
					if (X == '$')
						return "acc";
					else
						return "";
				} else {
					for (Character c : experssionSet.keySet()) {
						for (String l : experssionSet.get(c)) {

							if (c.equals(i.getLeft()) && l.equals(i.getRight()))
								return "r" + String.valueOf(r_count);
							else
								r_count++;
						}

					}

				}

			}

		}
		return "";

	}// 接受一个状态和一个输入码，如果有下一个状态，返回下个状态；如果没有，返回""；

	public String goto_fun_vn(int state, char X) {
		ArrayList<Item> I = new ArrayList<Item>();
		I = itemClass.get(state);
		int index;
		for (Item i : I) {
			index = i.getIndex();
			if (index < i.getRight().length()) {
				if (i.getRight().charAt(index) == X) {
					for (int count = 0; count < totalState; count++) {
						for (Item j : itemClass.get(count)) {
							if ((j.getRight().equals(i.getRight()) && j.getLeft().equals(i.getLeft()))
									&& j.getIndex() == index + 1) {
								return String.valueOf(count);
							}

						}
					}
				}
			} else {
				return "";
			}

		}
		return "";

	}// 接受一个状态和一个输入码，如果有下一个状态，返回下个状态；如果没有，返回-1；

	public void createDFA() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 6; j++) {
				DFA[i][j] = "";
			}
		}
		DFA[0][0] = "st";
		int count = 0;
		for (Character c : List) {
			count++;
			DFA[0][count] = c.toString();

		}
		for (count = 0; count < totalState; count++) {
			DFA[count + 1][0] = String.valueOf(count);
		}
		int vtSize = VtList.size();
		int vnSize = VnList.size();
		for (int i = 0; i < totalState; i++) {
			for (int j = 0; j < vtSize; j++) {
				DFA[i + 1][j + 1] = goto_fun_vt(i, VtList.get(j));
			}
			for (int j = 0; j < vnSize; j++) {
				DFA[i + 1][vtSize + j + 1] = goto_fun_vn(i, VnList.get(j));
			}
		}

	}

	public void initList(HashSet<Character> VnSet, HashSet<Character> VtSet) {
		Character ch = 'A';
		Character ch1 = '$';
		java.util.Iterator<Character> itVn = VnSet.iterator();
		java.util.Iterator<Character> itVt = VtSet.iterator();
		while (itVn.hasNext()) {
			VnList.add(itVn.next());
		}
		while (itVt.hasNext()) {
			VtList.add(itVt.next());
		}
		VnList.remove(ch);
		VtList.add(ch1);
		List.addAll(VtList);
		List.addAll(VnList);
	}

	public static void main(String[] args) {
		Analyze a = new Analyze();
		a.init();
		for (int state = 0; state < a.totalState; state++) {
			System.out.println("state:" + state);
			for (Item i : a.itemClass.get(state)) {
				i.printItem();
			}
		}

	}

	public String[][] init() {
		LR0 demo = new LR0();

		totalState = 0;
		demo.Init();
		demo.getNvNt();
		initList(demo.VnSet, demo.VtSet);
		experssionSet = demo.experssionSet;
		for (Character c : demo.VnSet) {
			for (String l : demo.experssionSet.get(c)) {
				for (int i = 0; i <= l.length(); i++) {
					Item item = new Item(i, c, l);
					items.add(item);
				}

			}
		}

		for (Item i : items) {
			if (!flag.contains(i)) {
				closure(i);
				totalState++;
			}
		}
		createDFA();
		return DFA;
	}

}