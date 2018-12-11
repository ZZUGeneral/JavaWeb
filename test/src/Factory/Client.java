package Factory;

public class Client {
	public static void main(String[] args) {
		ImageReaderFactory factory;
		factory = (ImageReaderFactory) XMLUtil.getBean();
		factory.read();
	}
}