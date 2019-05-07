package LR;

public class BeginCode extends NotEndCode {
	
	public void write() {
		System.out.print("S={");
		for (int i = 0; i < codeList.size(); i++) {
			System.out.print(codeList.get(i));
			if (i != codeList.size() - 1)
				System.out.print(",");
		}
		System.out.println("}");
	}
}
