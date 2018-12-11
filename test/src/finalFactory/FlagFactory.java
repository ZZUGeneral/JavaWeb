package finalFactory;

public abstract class FlagFactory {
	public abstract Flag produce_flag();

	public void show() {
		Flag flag = this.produce_flag();
		flag.show();
	}
}
