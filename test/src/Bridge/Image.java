package Bridge;

public abstract class Image {
	protected ImageImpl impl;

	public abstract void showImage(String file);

	public void setImpl(ImageImpl impl) {
		this.impl = impl;
	}

}