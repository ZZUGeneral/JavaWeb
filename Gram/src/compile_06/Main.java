package compile_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class Main {
	public static void main(String[] args) {
		
		FileProcess fileProcess=new FileProcess();
		fileProcess.fileProcess("C:\\Users\\YHL\\Desktop\\3.txt");
		Grammer grammer=new Grammer();
		grammer.setGrammer(fileProcess.getStringVn(), fileProcess.getStringVt(), 
								fileProcess.getStringP(), fileProcess.getStringS());
		grammer.extendGrammer();
		grammer.getGrammer();
		
		//System.out.println("--------项目集合---------");
		
		//生成全部的项目
		grammer.setNewProduce();
		/*
		 * for(int i=0;i<grammer.getNewProduce().size();i++) {
		 * System.out.println(grammer.getNewProduce().get(i).getNewLeft().getSignal()+
		 * "->"+ grammer.getNewProduce().get(i).getNewRight()); }
		 */
		
		System.out.println("--------闭包---------");
		ArrayList<NewProduce> listI=Tools.getNewProduce(grammer.getNewProduce(), "SS");
		
		LR0 lR0=new LR0();
		ArrayList<NewProduce> listJ=lR0.getClosure(listI, grammer);
		for(int i=0;i<listJ.size();i++) {
			System.out.println(listJ.get(i).getNewLeft().getSignal()+" "+listJ.get(i).getNewRight());
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
		//System.out.println("mm.size: "+mm.length);
		int line=grammer.getListSignalVn().size()+grammer.getListSignalVt().size();  //不包含扩展后的 SS
		int column=map.size();
		
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
		
		System.out.println("\n-------总控过程---------");
		
		System.out.println("步骤\t\t状态\t\t符号\t\t输入串\t\t动作");
		System.out.println(lR0.process(mm, "(a+b)#", grammer));
		
		
		System.out.println("\n-------语法分析树---------");
		System.out.println("-----除了顶层符号，其他符号存有上一层的父亲，即用[ ]表示-----");
		Stack<String> stack=lR0.getStack();
		boolean flag=true;
		while(stack.isEmpty()==false) {
			if(flag==true) {
				String temp=stack.pop();
				char[] tempChar=temp.toCharArray();
				for(int i=0;i<tempChar.length;i++) {
					if(i==0) {
						System.out.println(tempChar[i]);
					}else {
						System.out.print(tempChar[i]+"["+tempChar[0]+"]"+"  ");
					}
				}
				flag=false;
				System.out.println();
			}else {
				String temp=stack.pop();
				char[] tempChar=temp.toCharArray();
				for(int i=0;i<tempChar.length;i++) {
					if(i>0) {
						System.out.print(tempChar[i]+"["+tempChar[0]+"]"+"  ");
					}
				}
				System.out.println();
			}
		}	
	}
}
