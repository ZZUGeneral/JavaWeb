package Bridge;

public class JPGImage extends Image {
	public void showImage(String file) {
		Matrix m = new Matrix();
		impl.paint(m);
		System.out.println(file+",��ʽΪJPG.");
	}

}