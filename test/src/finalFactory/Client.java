package finalFactory;

public class Client {
	public static void main(String[] args) {
		FlagFactory factory;
		factory = (FlagFactory) XMLUtil.getBean();
		factory.show();
	}

}
