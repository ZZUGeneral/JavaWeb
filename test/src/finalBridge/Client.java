package finalBridge;

public class Client {
	public static void main(String[] arg) {
		WenBen wb;
		WenBenReader reader;
		wb = (WenBen) XMLUtil.getBean("WenBen");
		reader = (WenBenReader) XMLUtil.getBean("Reader");
		wb.setReader(reader);
		wb.readWenBen("´óÄÖÌì¹¬");
	}
}