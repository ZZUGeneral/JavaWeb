package simpleFactory;

import java.awt.Color;

public class Triangle implements Shape {
	private int size;
	private Color color;

	public void init() {
		System.out.println("��ʼ��riangle");
	}

	public void setColor(Color color) {
		this.color = color;
		System.out.println("�����ɫTriangle" + color);
	}

	public void fill() {
		System.out.println("���Triangle");
	}

	public void setSize(int size) {
		this.size = size;
		System.out.println("���óߴ�Triangle" + size);
	}

	public void display() {
		System.out.println("չʾTriangle");
	}

}