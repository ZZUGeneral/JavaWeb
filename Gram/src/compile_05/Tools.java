/**
 * 
 */
package compile_05;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author lpw
 *
 */
public class Tools {
	//数组转为字符串
	public static String ArrayToString(String[] str) {
		String tempStr="";
		for(int i=0;i<str.length;i++) {
			tempStr=tempStr+str[i];
		}
		return tempStr;
	}	
	
	//终结符的匹配
	public static int isContainVt(ArrayList<SignalVt> list, String str) {
		int index=-1;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getSignal().equals(str)) {
				index=i;
				break;
			}
		}
		return index;
	}
	
	//非终结符的匹配
	public static int isContainVn(ArrayList<SignalVn> list, String str) {
		int index=-1;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getSignal().equals(str)) {
				index=i;
				break;
			}
		}
		return index;
	}
	
	
	//查找NewProduce
	public static ArrayList<NewProduce> getNewProduce(ArrayList<NewProduce> list, String str) {
		ArrayList<NewProduce> listJ=new ArrayList<NewProduce>();
		for(int i=0;i<list.size();i++) {
			//System.out.println(list.get(i).getNewRight());
			if(list.get(i).getNewLeft().getSignal().equals(str) && list.get(i).getNewRight().substring(0, 1).equals(".")) {
				listJ.add(list.get(i));
			}
		}
		return listJ;
	}
	
	//判断newProduce是否存在于list
	public static boolean isContain(NewProduce newProduce, ArrayList<NewProduce> list) {
		boolean flag=false;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getNewLeft().getSignal().equals(newProduce.getNewLeft().getSignal()) &&
						list.get(i).getNewRight().equals(newProduce.getNewRight())) {
					flag=true;
					break;
			}
		}
		return flag;
	}
	
	//
	public static boolean isContain(ArrayList<NewProduce> list1, ArrayList<NewProduce> list2) {
		boolean flag=true;
		if(list1.size()==list2.size()) {
			for(int j=0;j<list1.size();j++) {
				NewProduce tempNew=list1.get(j);
				int isC=0;
				for(int k=0;k<list2.size();k++) {
					if(tempNew.getNewLeft().getSignal().equals(list2.get(k).getNewLeft().getSignal()) && 
							tempNew.getNewRight().equals(list2.get(k).getNewRight())) {
						isC=1;
						break;
					}
				}
				if(isC==0) {
					flag=false;
					break;
				}
			}
		}else {
			flag=false;
		}
		return flag;
	}
	
	
	//给产生式编号
	public static ArrayList<String> enCode(Grammer grammer) {
		ArrayList<ProduceP> produce=grammer.getListProduceP();
		
		ArrayList<String> en=new ArrayList<String>();
		for(int i=0;i<produce.size();i++) {
			ProduceP temp=produce.get(i);
			
			for(int j=0;j<temp.getRightProduce().size();j++) {
				String str=temp.getLeftProduce().getSignal()+Tools.ArrayToString(temp.getRightProduce().get(j));
				en.add(str);
			}
		}
		return en;
	}
}
