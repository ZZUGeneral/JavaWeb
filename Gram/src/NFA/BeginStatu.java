package NFA;

public class BeginStatu extends Status {
	public void addStatu(String statu) {
		staList.add(statu);
	}

	public void printStatus() {
		System.out.print("S0={");
		for (int i = 0; i < staList.size(); i++) {
			System.out.print(staList.get(i));
			if (i != staList.size() - 1)
				System.out.print(",");
		}
		System.out.println("}");
	}
}
