package NFA;

public class FinalStatus extends Status {
	public void printStatus() {
		System.out.print("F={");
		for (int i = 0; i < staList.size(); i++) {
			System.out.print(staList.get(i));
			if (i != staList.size() - 1)
				System.out.print(",");
		}
		System.out.println("}");
	}
}
