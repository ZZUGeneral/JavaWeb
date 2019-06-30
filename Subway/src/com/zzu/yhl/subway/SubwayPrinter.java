package com.zzu.yhl.subway;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class SubwayPrinter {
	private PrintStream out;
	private StringBuffer str;

	public SubwayPrinter(OutputStream out) {
		this.out = new PrintStream(out);
		str = new StringBuffer();
	}

	public void printDirections(List route) {
		Connection connection = (Connection) route.get(0);
		String currentLine = connection.getLineName();
		String previousLine = currentLine;
		out.println("Start out at " + connection.getStation1().getName() + ".");
		str.append("��" + connection.getStation1().getName() + "��ʼ.");
		out.println("Get on the " + currentLine + " heading towards " + connection.getStation2().getName() + ".\n");
		str.append("���ϴ�" + currentLine + "����" + connection.getStation2().getName() + "�ĵ�����\n");
		for (int i = 1; i < route.size(); i++) {
			connection = (Connection) route.get(i);
			currentLine = connection.getLineName();
			if (currentLine.equals(previousLine)) {
				out.println(" Continue past " + connection.getStation1().getName() + "...\n");
				str.append("����" + connection.getStation1().getName() + "...\n");
			} else {
				out.println("When you get to " + connection.getStation1().getName() + ", get off the " + previousLine
						+ ".");
				out.println("Switch over to the " + currentLine + ", heading towards "
						+ connection.getStation2().getName() + ".");
				str.append("���㵽��" + connection.getStation1().getName() + "ʱ���³�" + previousLine
						+ "��\n");
				str.append("ת�˴�" + currentLine + "����"
						+ connection.getStation2().getName() + "�ĵ�����\n");
				previousLine = currentLine;
			}
		}
		out.println("Get off at " + connection.getStation2().getName() + " and enjoy youself!");
		str.append("�ڵ���" + connection.getStation2().getName() + "ʱ�³��� \n ��Ŀ��ģ� \n");
	}

	public StringBuffer getStr() {
		return str;
	}

}
