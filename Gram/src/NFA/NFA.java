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
			/* ��ȡ״̬�� */
			String[] status = bReader.readLine().split(" ");
			staList.addStatu(status);
			/* ��ȡ��ĸ�� */
			String[] codes = bReader.readLine().split(" ");
			codeList.addCode(codes);
			/* ��ȡ��ֵ����ӳ�� */
			String[] functions = bReader.readLine().split(" ");
			int len1 = status.length;
			fun.addFun(len1, functions);
			/* ��ȡ��̬ */
			String beginStatu = bReader.readLine();
			beginList.addStatu(beginStatu);
			/* ��ȡ��̬ */
			String[] finalStatus = bReader.readLine().split(" ");
			finalList.addStatu(finalStatus);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("M=(S,��,��,S0,F):");
		staList.printStatus();
		codeList.printCode();
		beginList.printStatus();
		finalList.printStatus();
		fun.printFun();
	}

}
