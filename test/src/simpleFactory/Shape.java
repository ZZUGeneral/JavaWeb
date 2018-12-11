package simpleFactory;

import java.awt.Color;

public interface Shape {
	void init();

	void setColor(Color color);

	void fill();

	void setSize(int size);

	void display();
}