package simpleFactory;

import java.awt.Color;

public class Circle implements Shape {
	private int size;
	private Color color;

	public void init() {
		System.out.println("初始化Circle");
	}

	public void setColor(Color color) {
		System.out.println("设置颜色Circle" + color);
	}

	public void fill() {
		System.out.println("填充Circle");
	}

	public void setSize(int size) {
		System.out.println("设置尺寸Circle" + size);
	}

	public void display() {
		System.out.println("展示Circle");
	}
}