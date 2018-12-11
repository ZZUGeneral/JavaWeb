package finalFactory;

public class ChinaFlagFactory extends FlagFactory {

	@Override
	public Flag produce_flag() {
		// TODO Auto-generated method stub
		Flag flag = new ChinaFlag();
		return flag;
	}
}
