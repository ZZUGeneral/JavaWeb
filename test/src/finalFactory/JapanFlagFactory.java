package finalFactory;

public class JapanFlagFactory extends FlagFactory {

	@Override
	public Flag produce_flag() {
		// TODO Auto-generated method stub
		Flag flag = new JapanFlag();
		return flag;
	}

}
