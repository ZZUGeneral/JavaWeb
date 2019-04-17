package FFS;

import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		First f = new First();
		Map<String, Set<String>> firstMap = f.first();
		for (Map.Entry<String, Set<String>> entry : firstMap.entrySet()) {
			System.out.println("First(" + entry.getKey() + ")=" + entry.getValue());
		}

	}

}
