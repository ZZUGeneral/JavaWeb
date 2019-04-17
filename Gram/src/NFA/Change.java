package NFA;

public class Change {
	public int flag1;
	public int flag2;
	public char ch;

	public Change(int f1, int f2, char c) {
		this.flag1 = f1;
		this.flag2 = f2;
		this.ch = c;
	}

	public int getFlag1() {
		return flag1;
	}

	public void setFlag1(int flag1) {
		this.flag1 = flag1;
	}

	public int getFlag2() {
		return flag2;
	}

	public void setFlag2(int flag2) {
		this.flag2 = flag2;
	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

}
