package Change;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import NFA.BeginStatu;
import NFA.ChangeFunction;
import NFA.Code;
import NFA.FinalStatus;
import NFA.Status;

public class NTD {
	public static void main(String[] args) {
		List<Map<String, ArrayList<Integer>>> list = new ArrayList<Map<String, ArrayList<Integer>>>();
		NFA();

	}

	public static void NFA() {
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

			System.out.println("M=(S,��,��,s0,F):");
			fun.printFun();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

/* 0*5 5a5 5b5 5*1 1a3 3a2 4b1 4b2 2*6 6a6 6b6 6*7 */