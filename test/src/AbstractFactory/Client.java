package AbstractFactory;

public class Client {
	public static void main(String[] aegs) {
		SkinFactory factory;
		factory = (SkinFactory) XMLUtil.getBean();
		Button button = factory.createButton();
		TextField textField = factory.createTextField();
		ComboBox comboBox = factory.createComboBox();
		button.display();
		textField.display();
		comboBox.display();
	}
}