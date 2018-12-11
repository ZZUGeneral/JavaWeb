
package simpleFactory;

public class Factory {
	public static Shape createShape(String type) {
		Shape shape = null;
		if (type.equalsIgnoreCase("Circle")) {
			shape = new Circle();
			System.out.println("生成Circle");
		} else if (type.equalsIgnoreCase("Triangle")) {
			shape = new Triangle();
			System.out.println("生成Triangle");
		} else if (type.equalsIgnoreCase("Rectangle")) {
			shape = new Rectangle();
			System.out.println("生成Rectangle");
		}
		return shape;
	}

}