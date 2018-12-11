package Bridge;

public class BMPImage extends Image {
	public void showImage(String file) {
		Matrix m = new Matrix();
		impl.paint(m);
		System.out.println(file + ",¸ñÊ½ÎªBMP.");
	}

}