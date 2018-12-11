package simpleFactory;

import java.awt.Color;

public class Circle implements Shape {
	private int size;
	private Color color;

	public void init() {
		System.out.println("��ʼ��Circle");
	}

	public void setColor(Color color) {
		System.out.println("������ɫCircle" + color);
	}

	public void fill() {
		System.out.println("���Circle");
	}

	public void setSize(int size) {
		System.out.println("���óߴ�Circle" + size);
	}

	public void display() {
		System.out.println("չʾCircle");
	}
}