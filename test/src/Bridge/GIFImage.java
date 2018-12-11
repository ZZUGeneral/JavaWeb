package Bridge;

public class GIFImage extends Image {
	public void showImage(String file) {
		Matrix m = new Matrix();
		impl.paint(m);
		System.out.println(file + ",格式为GIF.");
	}

}