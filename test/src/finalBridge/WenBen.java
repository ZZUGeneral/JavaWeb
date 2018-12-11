package finalBridge;

public abstract class WenBen {
	protected WenBenReader reader;

	public abstract void readWenBen(String file);

	public void setReader(WenBenReader reader) {
		this.reader = reader;
	}

}