package Factory;

public class GitReaderFactory extends ImageReaderFactory {
	public ImageReader createReader() {
		return new GitReader();
	}

}