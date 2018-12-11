package Bridge;

public class PNGIamge extends Image {
	public void showImage(String file) {
		Matrix m = new Matrix();
		impl.paint(m);
		System.out.println(file + ",¸ñÊ½ÎªPNG.");
	}

}