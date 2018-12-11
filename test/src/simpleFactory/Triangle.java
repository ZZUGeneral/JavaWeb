package simpleFactory;

import java.awt.Color;

public class Triangle implements Shape {
	private int size;
	private Color color;

	public void init() {
		System.out.println("初始化riangle");
	}

	public void setColor(Color color) {
		this.color = color;
		System.out.println("设置顔色Triangle" + color);
	}

	public void fill() {
		System.out.println("填充Triangle");
	}

	public void setSize(int size) {
		this.size = size;
		System.out.println("设置尺寸Triangle" + size);
	}

	public void display() {
		System.out.println("展示Triangle");
	}

}