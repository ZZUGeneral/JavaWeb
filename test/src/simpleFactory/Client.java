
package simpleFactory;

public class Client {
	public static void main(String[] args) {
		Shape shape;
		String type = XMLUtil.getShapeType();
		shape = Factory.createShape(type);
		shape.display();
	}

}