/**
 * 
 */
package compile_05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author lpw
 *
 */
public class LR0 {
	private ArrayList<String> listString;
	
	//根据集合 求闭包
	public ArrayList<NewProduce> getClosure(ArrayList<NewProduce> list, Grammer grammer){
		ArrayList<NewProduce> listJ=list;
		boolean flag=true;
		while(flag) {
			int isRec=0;
			for(int i=0;i<listJ.size();i++) {
				int index=listJ.get(i).getNewRight().indexOf(".");
				if(index==-1) {
					System.out.println("未找到符号");
					return null;
				}else {
					if(index+1==listJ.get(i).getNewRight().length()) {
						
					}else {
						//获取子字符串
						String subStr=listJ.get(i).getNewRight().substring(index+1, index+2);
						if(Tools.isContainVn(grammer.getListSignalVn(), subStr)!=-1) {
							
							//获取集合
							ArrayList<NewProduce> recursionList=Tools.getNewProduce(grammer.getNewProduce(), subStr);
		
							//相当于递归
							ArrayList<NewProduce> listRecJ=new LR0().getClosure(recursionList, grammer);
							for(int j=0;j<listRecJ.size();j++) {
								if(Tools.isContain(listRecJ.get(j), listJ)==false) {
									//不存在则加入
									listJ.add(listRecJ.get(j));
									isRec=1;
								}
							}
						}else {
							//如果 . 后面是终结符 什么也不做
						}
					}
				}
			}
			
			//判断是否循环
			if(isRec==0){
				flag=false;
			}else {
				flag=true;
			}
		}
		
		return listJ;
	}
	
	
	//状态转换函数
	public ArrayList<NewProduce> go(ArrayList<NewProduce> list, String str, Grammer grammer){
		ArrayList<NewProduce> listC=new ArrayList<NewProduce>();
		
		for(int i=0;i<list.size();i++) {
			int index=list.get(i).getNewRight().indexOf(".");
			
			if(index+1==list.get(i).getNewRight().length()) {
				return listC;
			}
			String subStr=list.get(i).getNewRight().substring(index+1, index+2);
			if(subStr.equals(str)) {
				
				//NewProduce tempNew=list.get(i);
				NewProduce tempNew=new NewProduce();
				tempNew.setLeft(list.get(i).getNewLeft().getSignal());
				String tempStr;
				if(list.get(i).getNewRight().length()==index+2) {
					if(index==0) {
						tempStr=subStr+".";
					}else {
						tempStr=list.get(i).getNewRight().substring(0, index)+subStr+".";
					}
				}else {
					if(index==0) {
						tempStr=subStr+"."+list.get(i).getNewRight().substring(index+2, list.get(i).getNewRight().length());
					}else {
						tempStr=list.get(i).getNewRight().substring(0, index)+subStr+"."+
								list.get(i).getNewRight().substring(index+2, list.get(i).getNewRight().length());
					}
				}
				
				tempNew.setRight(tempStr);
				listC.add(tempNew);
			}else {
				
			}
		}
		
		return getClosure(listC, grammer);
	}
	
	//计算项目集族
	public HashMap<Integer, ArrayList<NewProduce>> getCollect(ArrayList<NewProduce> list, Grammer grammer){
		HashMap<Integer, ArrayList<NewProduce>> map=new HashMap<Integer, ArrayList<NewProduce>>();
		this.listString = new ArrayList();
		int count = 0;
		map.put(count++, list);
		
		boolean flag=true;
		while(flag) {
			int isCon=0;
			
			for(int i=0;i<map.size();i++) {
				ArrayList<NewProduce> tempList=map.get(i);
			
				//Vt
				for(int j=0; j<grammer.getListSignalVt().size();j++) {
					ArrayList<NewProduce> listc=go(tempList, grammer.getListSignalVt().get(j).getSignal(), grammer);
					
					int account=0;
					if(listc.size()==0) {
						
					}else {
						
						
						for(int k=0;k<map.size();k++) {
							if(Tools.isContain(map.get(k), listc)) {
								//从状态 i 到状态 i+1， 经过vt/vn
								this.listString.add(""+(i)+" "+grammer.getListSignalVt().get(j).getSignal()+" "+(k));
								//break;
							}else {
								account++;
							}
						}
						if(map.size()==account) {
							//从状态 i 到状态 i+1， 经过vt/vn
							this.listString.add(""+(i)+" "+grammer.getListSignalVt().get(j).getSignal()+" "+(count));
							map.put(count++, listc);
							
							//System.out.println("map.size= "+map.size());
						}
					}
					
				}
				
				//Vn
				for(int j=0; j<grammer.getListSignalVn().size();j++) {
					ArrayList<NewProduce> listc=go(tempList, grammer.getListSignalVn().get(j).getSignal(), grammer);

					int account=0;
					if(listc.size()==0) {
						
					}else {
						
						
						for(int k=0;k<map.size();k++) {
							if(Tools.isContain(map.get(k), listc)) {
								//从状态 i 到状态 i+1， 经过vt/vn
								this.listString.add(""+(i)+" "+grammer.getListSignalVn().get(j).getSignal()+" "+(k));
								//break;
							}else {
								account++;
							}
						}
						if(map.size()==account) {
							//从状态 i 到状态 i+1， 经过vt/vn
							this.listString.add(""+(i)+" "+grammer.getListSignalVn().get(j).getSignal()+" "+(count));
							map.put(count++, listc);
							//System.out.println("map.size= "+map.size());
						}
					}
				}
			}
			
			//是否循环
			if(isCon==1) {
				flag=true;
			}else {
				flag=false;
			}
		}
		
		return map;
	}
	
	
	
	public String[] getLRTable(HashMap<Integer, ArrayList<NewProduce>> map, Grammer grammer) {
		int line=grammer.getListSignalVn().size()+grammer.getListSignalVt().size();  //不包含扩展后的 SS
		int column=map.size();
		
		String[] table=new String[line*column];
		//初始化
		for(int i=0;i<line*column;i++) {
			table[i]="";
		}
		
		
		for(int i=0;i<this.listString.size();i++) {
			String[] tempArray=this.listString.get(i).split(" ");
			
			//规约
			int index=Integer.parseInt(tempArray[0]);
			//String tempStr=tempArray[1];
			
			if(Tools.isContainVn(grammer.getListSignalVn(), tempArray[1])!=-1) {
				int add=grammer.getListSignalVt().size()+Tools.isContainVn(grammer.getListSignalVn(), tempArray[1]);
				table[index*line+1+add]=tempArray[2];
			}else {
				if(map.get(index).size()==1) {
					if(map.get(index).get(0).getNewRight().substring(map.get(index).get(0).getNewRight().length()-1, map.get(index).get(0).getNewRight().length()).equals(".")){
						if(map.get(index).get(0).getNewLeft().getSignal().equals(grammer.getSignalVn().getSignal())) {
							//接受
							table[index*line+grammer.getListSignalVn().size()]="acc";
						}else {
							//归约
							int add=grammer.getListSignalVt().size();
							for(int j=0;j<add;j++) {
								table[index*line+j]="r"+""+tempArray[2];
							}
						}
					}else {
						//移进
						int add1=Tools.isContainVt(grammer.getListSignalVt(), tempArray[1]);
						//System.out.println(i+" "+tempArray[1]+" "+add1);
						table[index*line+add1]="s"+tempArray[2]; 
					}
				}else {
					//移进
					int add=Tools.isContainVt(grammer.getListSignalVt(), tempArray[1]);
					table[index*line+add]="s"+tempArray[2]; //将 状态 vt  移进 
				}
			}
		}
		
		for(int i=0;i<map.size();i++) {
			if(map.get(i).size()==1) {
				if(map.get(i).get(0).getNewRight().substring(map.get(i).get(0).getNewRight().length()-1, map.get(i).get(0).getNewRight().length()).equals(".")) {
					if(map.get(i).get(0).getNewLeft().getSignal().equals(grammer.getSignalVn().getSignal())) {
						//接受
						table[i*line+1+grammer.getListSignalVn().size()]="acc";
					}else {
						//归约
						String str=map.get(i).get(0).getNewLeft().getSignal()+map.get(i).get(0).getNewRight().substring(0, map.get(i).get(0).getNewRight().length()-1);
						
						ArrayList<String> list=Tools.enCode(grammer);
						/*for(int k=0;k<list.size();k++) {
							System.out.println(list.get(k));
						}*/
						int n=-1;
						for(int k=0;k<list.size();k++) {
							
							if(list.get(k).equals(str)) {
								n=k;
								break;
							}
						}
						
						int add=grammer.getListSignalVt().size()+1;
						for(int j=0;j<add;j++) {
							table[i*line+j]="r"+n;
						}
					}
				}
			}
		}
		return table;
	}
	
	public ArrayList<String> getList(){
		return this.listString;
	}
	
	public boolean process(String[] mm, String str, Grammer grammer) {
		/*
		 * 输入串： aaaaaaa# 形式
		 */
		ArrayList<String> p=Tools.enCode(grammer);
		for(int i=0;i<p.size();i++) {
			System.out.println(p.get(i));
		}
		System.out.println("======");
		
		Stack<String> stackC=new Stack<String>(); //字符栈
		Stack<String> stackS=new Stack<String>();//状态栈
		
		//初始化
		stackS.push("0");
		stackC.push("#");
		
		int count=0;
		int line=grammer.getListSignalVn().size()+grammer.getListSignalVt().size();  //长度
		System.out.println(line);
		
		boolean flag=true;
		while(flag) {
			
			int index=Tools.isContainVt(grammer.getListSignalVt(), str.substring(count, count+1));
			
			if(Tools.isContainVt(grammer.getListSignalVt(), str.substring(count, count+1))!=-1) {
				index=Tools.isContainVt(grammer.getListSignalVt(), str.substring(count, count+1));
			}else {
				index=grammer.getListSignalVt().size();
			}
			System.out.println(str.substring(count, count+1)+" "+index);
			
			System.out.println("S: "+stackS.get(stackS.size()-1));
			String string=mm[Integer.parseInt(stackS.get(stackS.size()-1))*line+index];
			System.out.println("Str: "+string);
			if(string.equals("")) {
				return false;
			}else {
				if(string.substring(0, 1).equals("s")) {
					stackS.push(string.substring(1, 2));
					stackC.push(str.substring(count, count+1));
					count++;
				}else if(string.substring(0, 1).equals("r")) {
					ArrayList<String> list=Tools.enCode(grammer);
					int length=list.get(Integer.parseInt(string.substring(1, 2))).length()-1;
					System.out.println("length: "+length);
					for(int i=0;i<length;i++) {
						stackS.pop();
						stackC.pop();
					}
					System.out.println("1rs: "+stackS.get(stackS.size()-1));
					System.out.println("1rc: "+stackC.get(stackC.size()-1));
					
					stackC.push(list.get(Integer.parseInt(string.substring(1, 2))).substring(0, 1));
					System.out.println("2rc: "+stackC.get(stackC.size()-1));
					
					int indexVn=Tools.isContainVn(grammer.getListSignalVn(), 
							list.get(Integer.parseInt(string.substring(1, 2))).substring(0, 1));
					System.out.println("Vn: "+indexVn);
					String string1=mm[Integer.parseInt(stackS.get(stackS.size()-1))*line+grammer.getListSignalVt().size()+1+indexVn];
					System.out.println(string1);
					stackS.push(string1);
					System.out.println("2rs: "+stackS.get(stackS.size()-1));
					
				}else if(string.equals("acc")) {
					return true;
				}
			}
		}
		return true;
	}
}
