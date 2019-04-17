package NFA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import NFA.BeginStatu;
import NFA.ChangeFunction;
import NFA.Code;
import NFA.FinalStatus;
import NFA.Status;

public class NFA {
	public static void main(String[] args) {
		Status staList = new Status();
		BeginStatu beginList = new BeginStatu();
		FinalStatus finalList = new FinalStatus();
		ChangeFunction fun = new ChangeFunction();
		Code codeList = new Code();
		File file = new File("C:\\Users\\YHL\\Desktop\\test.txt");
		FileReader reader;
		try {
			reader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(reader);
			/* 获取状态集 */
			String[] status = bReader.readLine().split(" ");
			staList.addStatu(status);
			/* 获取字母表 */
			String[] codes = bReader.readLine().split(" ");
			codeList.addCode(codes);
			/* 获取单值部分映射 */
			String[] functions = bReader.readLine().split(" ");
			int len1 = status.length;
			fun.addFun(len1, functions);
			/* 获取初态 */
			String beginStatu = bReader.readLine();
			beginList.addStatu(beginStatu);
			/* 获取终态 */
			String[] finalStatus = bReader.readLine().split(" ");
			finalList.addStatu(finalStatus);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("M=(S,∑,δ,S0,F):");
		staList.printStatus();
		codeList.printCode();
		beginList.printStatus();
		finalList.printStatus();
		fun.printFun();
	}

}
