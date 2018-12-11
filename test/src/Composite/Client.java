package Composite;

public class Client {
	public static void main(String[] args) {
		AbstractSchool as1,as2,as3,as4,as5,as6,as7,as8;
		ChildSchool cs1,cs2,cs3,cs4;
		
		as1 = new JW_Work();
		as2 = new XZ_Work();
		cs1 = new ChildSchool();
		cs1.add(as1);
		cs1.add(as2);
		
		as3 = new JW_Work();
		as4 = new XZ_Work();
		cs2 = new ChildSchool();
		cs2.add(as3);
		cs2.add(as4);
		
		as5 = new JW_Work();
		as6 = new XZ_Work();
		cs3 = new ChildSchool();
		cs3.add(as5);
		cs3.add(cs1);
		cs3.add(cs2);
		cs3.add(as6);
		
		as7 = new JW_Work();
		as8 = new XZ_Work();
		cs4 = new ChildSchool();
		
		cs4.add(as7);
		cs4.add(cs3);
		cs4.add(as8);
		
		cs4.notice("123");
		
	}

}
