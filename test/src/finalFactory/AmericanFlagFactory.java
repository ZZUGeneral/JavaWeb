package finalFactory;

public class AmericanFlagFactory extends FlagFactory {
	
	public AmericanFlagFactory() {
		
	}

	@Override
	public Flag produce_flag() {
		// TODO Auto-generated method stub
		Flag flag = new AmericanFlag();
		return flag;
	}

}
