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
public class Main {
	public static void main(String[] args) {
		/*
		 * 扩展文法
		 */
		FileProcess fileProcess=new FileProcess();
		fileProcess.fileProcess("C:\\Users\\yhl\\Desktop\\test.txt");
		Grammer grammer=new Grammer();
		grammer.setGrammer(fileProcess.getStringVn(), fileProcess.getStringVt(), 
								fileProcess.getStringP(), fileProcess.getStringS());
		grammer.extendGrammer();
		grammer.getGrammer();
		
		System.out.println("-----------------");
		
		//生成全部的项目
		grammer.setNewProduce();
		for(int i=0;i<grammer.getNewProduce().size();i++) {
			System.out.println(grammer.getNewProduce().get(i).getNewLeft().getSignal()+"->"+
					grammer.getNewProduce().get(i).getNewRight());
		}
		
		System.out.println("--------闭包---------");
		ArrayList<NewProduce> listI=Tools.getNewProduce(grammer.getNewProduce(), "SS");
		
		LR0 lR0=new LR0();
		ArrayList<NewProduce> listJ=lR0.getClosure(listI, grammer);
		for(int i=0;i<listJ.size();i++) {
			System.out.println(listJ.get(i).getNewLeft().getSignal()+" "+listJ.get(i).getNewRight());
		}
		
		System.out.println("---------Go--------");
		ArrayList<NewProduce> listGo=lR0.go(listJ, "a", grammer);
		for(int i=0;i<listGo.size();i++) {
			System.out.println(listGo.get(i).getNewLeft().getSignal()+" "+listGo.get(i).getNewRight());
		}
		
		System.out.println("-------项目族---------");
		HashMap<Integer, ArrayList<NewProduce>> map=lR0.getCollect(listJ, grammer);
		System.out.println("size: "+map.size());
		for(int i=0;i<map.size();i++) {
			System.out.println("I = "+i);
			for(int j=0;j<map.get(i).size();j++){
				System.out.println(map.get(i).get(j).getNewLeft().getSignal()+"->"+
						map.get(i).get(j).getNewRight());
			}
		}
		
		System.out.println("-------状态转移---------");
		ArrayList<String> lll=lR0.getList();
		for(int i=0;i<lll.size();i++) {
			System.out.println(lll.get(i));
		}
		
		System.out.println("-------分析表---------");
		String[] mm=lR0.getLRTable(map, grammer);
		System.out.println("mm.size: "+mm.length);
		int line=grammer.getListSignalVn().size()+grammer.getListSignalVt().size();  //不包含扩展后的 SS
		int column=map.size();
		
		System.out.println("line: "+line+"    co: "+column);
		System.out.print(" \t\t");
		for(int i=0;i<grammer.getListSignalVt().size();i++) {
			System.out.print(grammer.getListSignalVt().get(i).getSignal()+"\t\t");
		}
		System.out.print("#"+"\t\t");
		for(int i=0;i<grammer.getListSignalVn().size()-1;i++) {
			System.out.print(grammer.getListSignalVn().get(i).getSignal()+"\t\t");
		}
		System.out.println();
		for(int i=0;i<map.size();i++) {
			System.out.print(i+"\t\t");
			for(int j=0;j<line;j++) {
				System.out.print(mm[i*line+j]+"\t\t");
			}
			System.out.println();
		}
		
		System.out.println("-------总控过程---------");
		System.out.println(lR0.process(mm, "(a)#", grammer));
	}
}
