package LR;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Closure {
	private int from;
	private int to;
	private String ch;
	private List<String> list = new ArrayList<String>();

	public Closure(int from, int to, String ch, List<String> list) {
		// TODO Auto-generated constructor stub
		this.from = from;
		this.to = to;
		this.ch = ch;
		this.list = list;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public String getCh() {
		return ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Closure [from=" + from + ", to=" + to + ", ch=" + ch + ", list=" + list + "]";
	}

	

}
