package Factory;

public abstract class ImageReaderFactory {
	public abstract ImageReader createReader();

	public void read() {
		ImageReader reader = this.createReader();
		reader.read();

	}

}