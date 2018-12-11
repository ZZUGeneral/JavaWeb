package Composite;

import java.util.ArrayList;

public class ChildSchool  extends AbstractSchool{
	private ArrayList<AbstractSchool> list = new ArrayList<AbstractSchool>();

	@Override
	public void notice(String str) {
		// TODO Auto-generated method stub
		for(AbstractSchool as: list) {
			((AbstractSchool)as).notice(str);
		}
	}
	public void add(AbstractSchool as) {
		list.add(as);
	}
	public void remove(AbstractSchool as) {
		list.remove(as);
		
	}

}
