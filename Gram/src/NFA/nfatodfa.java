package NFA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class nfatodfa {
	private static String chushizhuangtai = null;
	public static ArrayList<String> zifuji = new ArrayList<>(); // �ַ���
	private static ArrayList<String> nfazhuangtai = new ArrayList<>(); // NFA״̬��
	public static ArrayList<String> jieshuzhuangtai = new ArrayList<>(); // ����״̬��
	private static ArrayList<String> zifuhu = new ArrayList<>(); // �ַ���
	private static ArrayList<String> konghu = new ArrayList<>(); // �ջ�
	private static HashMap<String, String> kongji = new HashMap<>();
	public static HashMap<String, String> dfahanshu = new HashMap<>();
	private static String dfachutai = null; // DFA��ʼ״̬
	public static ArrayList<String> a4 = new ArrayList<>(); // ����dfaÿ��״̬

	public nfatodfa(String chushizhuangtai2, ArrayList<String> jieshuzhuangtai1, ArrayList<String> zifuji1,
			ArrayList<String> nfazhuangtai1, ArrayList<String> konghu2, ArrayList<String> zifuhu2) {
		// TODO Auto-generated constructor stub
		this.chushizhuangtai = chushizhuangtai2;
		this.jieshuzhuangtai = jieshuzhuangtai1;
		this.zifuji = zifuji1;
		this.nfazhuangtai = nfazhuangtai1;
		this.konghu = konghu2;
		this.zifuhu = zifuhu2;
	}

	// �ӿ�ʼ״̬��ʼ��ȡ��һ��DFA����״̬������������
	// s5 ��ʼ״̬
	public static void xhdfahanshu(String s5) {
		ArrayList<String> aaaaaa = new ArrayList<>();
		String s6 = "";
		a4.add(s5);
		int i = 0;
		while (i != a4.size()) {
			int m = a4.size();
			String[] si = (String[]) a4.toArray(new String[m]);
			for (String zifu : zifuji) { // ����ÿһ���ַ�
				String s1 = getzifu(si[i], zifu);
				for (int j = 0; j < s1.length(); j++) {
					char c2 = s1.charAt(j);
					String s2 = String.valueOf(c2);
					String s3 = kongji.get(s2);
					aaaaaa.add(s3);
				}
				if (!aaaaaa.isEmpty()) {
					String s4 = strxiangjia(aaaaaa);
					aaaaaa.clear();
					if (!a4.contains(s4)) {
						a4.add(s4);
					}
					s6 = si[i].toString();
					s6 += ":" + zifu;
					dfahanshu.put(s6, s4);
				}

			}
			i++;
		}
	}

	// ��N�����Ͻ��кϲ�
	// ÿһ��value����һ������
	// �ϲ���ļ���
	public static String strxiangjia(ArrayList<String> arr) {
		SortedSet<Character> sd = new TreeSet<>();
		String ss = "";
		for (String s : arr) {
			for (int i = 0; i < s.length(); i++) {
				sd.add(s.charAt(i));
			}
		}
		for (char c : sd) {
			ss += c;
		}
		return ss;
	}

	// ׼������
	// ��ȡS��ÿһ��״̬����zifu���ﵽ��״̬
	public static String getzifu(String s, String zifu) {
		int i = s.length();
		String s1 = "";

		for (int j = 0; j < i; j++) {
			char c = s.charAt(j);
			String ss = String.valueOf(c);
			for (String sss : zifuhu) {
				if (sss.startsWith(ss) && sss.charAt(1) == zifu.charAt(0)) {
					s1 += sss.charAt(2);
				}
			}
		}
		return s1;

	}

	// NFA�е�ÿһ��״̬�����ջ��󵽴��״̬
	public static void KongJi() {

		for (String s : nfazhuangtai) {
			String sss = "";
			tranji.add(s);
			Get_ztj(s);
			for (String ss : tranji)
				sss += ss;
			kongji.put(s, sss); // ĳһ�ַ������ջ������״̬��
			tranji.clear();

		}
	}

	// ��ÿһ��״̬�����ջ��ҵ���״̬ ��110����ʹ��
	private static SortedSet<String> tranji = new TreeSet<>();

	public static void Get_ztj(String zt) {
		for (String s : konghu) {
			if (s.startsWith(zt)) {
				tranji.add(s.substring(2));
				Get_ztj(s.substring(2));
			}
		}
	}

	public static void Get_DfaFirst(String cszt) {
		for (String s : konghu) {
			if (s.startsWith(cszt)) {
				dfachutai += s.substring(2);
				Get_DfaFirst(s.substring(2));
			}
		}
	}

	public static void GetDfaFirst() {
		dfachutai = chushizhuangtai;
		Get_DfaFirst(chushizhuangtai);
	}

	public static void wjGet_Nfa() {
		File file = new File("E:/ceshi.txt");
		String s = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((s = br.readLine()) != null) {
				char c = s.charAt(0);
				switch (c) {
				case '0':
					chushizhuangtai = s.substring(1);
					break;
				case '1':
					jieshuzhuangtai.add(s.substring(1));
					break;
				case '2':
					zifuji.add(s.substring(1));
					break;
				case '3':
					nfazhuangtai.add(s.substring(1));
					break;
				case '4':
					if (s.charAt(2) == '#')
						konghu.add(s.substring(1));
					else
						zifuhu.add(s.substring(1));
					break;
				default:
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Get_Nfa() {
		System.out.print("�����ʼ״̬��");
		Scanner s = new Scanner(System.in);
		chushizhuangtai = s.next(); // ��ʼ״̬
		System.out.println("�������״̬��");
		Scanner sc5 = new Scanner(System.in);
		while (true) {
			String jieshu = sc5.next();
			if (jieshu.equals("over"))
				break;
			else {
				jieshuzhuangtai.add(jieshu);
			}
		}
		System.out.println("�����ַ�����"); // �ַ���
		Scanner s1 = new Scanner(System.in);
		while (true) {
			String ss1 = s1.next();
			if (ss1.equals("over")) {
				break;
			} else {
				zifuji.add(ss1);
			}
		}

		System.out.println("����NFA״̬����");
		Scanner s2 = new Scanner(System.in);
		while (true) {
			String ss2 = s2.next();
			if (ss2.equals("over")) {
				break;
			} else {
				nfazhuangtai.add(ss2);
			}
		}

		System.out.println("���뺯������"); // ������
		Scanner sc = new Scanner(System.in);
		while (true) {
			String nfa = sc.next();
			if (nfa.equals("over"))
				break;
			else if (nfa.charAt(1) == '#')
				konghu.add(nfa);
			else
				zifuhu.add(nfa);
		}

	}

//��������������������߿��Լ��޸�
	public static void main(String[] args) {
		wjGet_Nfa();
		GetDfaFirst();
		KongJi();
		xhdfahanshu(dfachutai);
		// new Tuxing(dfahanshu,a4);
		System.out.println(konghu);
		System.out.println(zifuhu);
		System.out.println(dfachutai);
		System.out.println(kongji);
		System.out.println(dfahanshu);

	}
}
