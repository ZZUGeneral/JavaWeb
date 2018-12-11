package Bridge;

public class Client {
	public static void main(String[] arg) {
		Image image;
		ImageImpl impl;
		image = (Image) XMLUtil.getBean("image");
		impl = (ImageImpl) XMLUtil.getBean("os");
		image.setImpl(impl);
		image.showImage("ÉñµñÏÀÂÂ");
	}
}