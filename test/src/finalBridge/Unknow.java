package finalBridge;

public class Unknow extends WenBen {
	@Override
	public void readWenBen(String file) {
		Character c = new Character();
		reader.read(c);
		System.out.println(file + ",¸ñÊ½ÎªDOC.");
	}

}