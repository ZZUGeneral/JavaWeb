package test;

import java.util.Scanner;

/**
 * 
 * @author YHL
 *
 */
public class WJNY {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入字符串：");
		String code = scan.next();
		code = code.toUpperCase();
		char[] word = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		String words = new String(word);
		int[] deCode = { 2, 8, 15, 7, 4, 17 };
		char[] newCode = code.toCharArray();
		menu();
		int cs = scan.nextInt();
		switch (cs) {
		case 1:
			int i = 0;
			for (i = 0; i < newCode.length; i++) {
				int index = words.indexOf(code.charAt(i)) + deCode[i % 6];
				newCode[i] = word[index % 26];
			}
			System.out.println(new String(newCode));
			break;
		case 2:
			int j = 0;
			for (j = 0; j < newCode.length; j++) {
				int index = words.indexOf(code.charAt(j)) - deCode[j % 6];
				while (index < 0)
					index = index + 26;
				newCode[j] = word[index % 26];
			}
			System.out.println(new String(newCode));
			break;
		}
	}

	public static void menu() {
		System.out.println("----  菜单     ---");
		System.out.println("----1. 加密----");
		System.out.println("----2. 解密----");
		System.out.println("----0. 退出 ----");
	}

}
