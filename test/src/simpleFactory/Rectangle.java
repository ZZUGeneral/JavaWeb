package simpleFactory;

import java.awt.Color;

public class Rectangle implements Shape {
	private int size;
	private Color color;

	public void init() {
		System.out.println("��ʼ��Recangtle");
	}

	public void setColor(Color color) {
		this.color = color;
		System.out.println("������ɫRecangtle" + color);
	}

	public void fill() {
		System.out.println("���Recangtle");
	}

	public void setSize(int size) {
		this.size = size;
		System.out.println("���óߴ�Recangtle" + size);
	}

	/** @pdOid 2312f2e0-e843-41ed-a183-d6e2471e8b14 */
	public void display() {
		System.out.println("展示Recangtle");
	}

}