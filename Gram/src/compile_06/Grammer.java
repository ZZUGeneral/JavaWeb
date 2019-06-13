package compile_06;

import java.util.ArrayList;

class Grammer {
	//非终结符
	private ArrayList<SignalVn> listVn;
	
	//终结符
	private ArrayList<SignalVt> listVt;
	
	//开始符
	private SignalVn signalVn;
	
	//产生式
	private ArrayList<ProduceP> listP;
	
	//扩展产生式
	private ArrayList<NewProduce> listNew;
	
	public Grammer() {
		this.listVn=new ArrayList<SignalVn>();
		this.listVt=new ArrayList<SignalVt>();
		this.signalVn=new SignalVn();
		this.listP=new ArrayList<ProduceP>();
		this.listNew=new ArrayList<NewProduce>();
	}
	
	public void setGrammer(String strVn, String strVt, ArrayList<String> strP, String strS) {
		String[] tempStrVn=strVn.split(" ");
		for(int i=0;i<tempStrVn.length;i++) {
			SignalVn signalVn=new SignalVn();
			signalVn.setSignal(tempStrVn[i]);
			this.listVn.add(signalVn);
			//System.out.println(this.listVn.get(i).getSignal());
		}
		
		//System.out.println("------------");
		
		String[] tempStrVt=strVt.split(" ");
		for(int i=0;i<tempStrVt.length;i++) {
			SignalVt signalVt=new SignalVt();
			signalVt.setSignal(tempStrVt[i]);
			this.listVt.add(signalVt);
		}
		
		
		for(int i=0;i<strP.size();i++) {
			ProduceP produceP=new ProduceP();
			produceP.setProduce(strP.get(i));
			this.listP.add(produceP);
		}
		
		this.signalVn.setSignal(strS);
	}
	//在读取文件的内容时一定要注意文件不能有多余的空格和换行
	
	public void getGrammer() {
		System.out.println("文法 G=(Vn, Vt, P, S), 其中：");
		//输出非终结符
		System.out.print("Vn={");
		for(int i=0;i<this.listVn.size();i++) {
			if(i==this.listVn.size()-1) {
				System.out.println(this.listVn.get(i).getSignal()+"}");
			}else {
				System.out.print(this.listVn.get(i).getSignal()+", ");
			}
		}
		//输出终结符
		System.out.print("Vt={");
		for(int i=0;i<this.listVt.size();i++) {
			if(i==this.listVt.size()-1) {
				System.out.println(this.listVt.get(i).getSignal()+"}");
			}else {
				System.out.print(this.listVt.get(i).getSignal()+", ");
			}
		}
		//输出产生式集
		System.out.print("P={");
		for(int i=0;i<this.listP.size();i++) {
			if(i==this.listP.size()-1) {
				System.out.println(this.listP.get(i).showProduce()+"}");
			}else {
				System.out.print(this.listP.get(i).showProduce()+", ");
			}
		}
		//输出开始符
		System.out.println("S="+this.signalVn.getSignal());
	}
	
	/*
	 * 扩展文法生成
	 */
	public void extendGrammer() {
		//创建新的产生式
		ProduceP tempProduce=new ProduceP();
		tempProduce.setProduce("SS "+this.signalVn.getSignal());
		
		//将新的产生式加入
		this.listP.add(tempProduce);
		this.signalVn.setSignal("SS");    //改变开始符号
		this.listVn.add(this.signalVn);   //添加新的非终结符
	}
	
	//产生项目集
	public void setNewProduce() {
		for(int i=0;i<this.listP.size();i++) {
			ProduceP tempProduce=listP.get(i);
			
			for(int j=0;j<tempProduce.getRightProduce().size();j++) {
				
				//获得产生式右部
				String[] tempArray=tempProduce.getRightProduce().get(j);
				
				for(int k=0;k<=tempArray.length;k++) {
					String tempStr=Tools.ArrayToString(tempArray);
					StringBuffer stringBuilder1=new StringBuffer(tempStr);
					stringBuilder1.insert(k, ".");
					
					//创建新的项目
					NewProduce newProduce=new NewProduce();
					
					//System.out.println("Left: "+tempProduce.getLeftProduce().getSignal());
					newProduce.setLeft(tempProduce.getLeftProduce().getSignal());
					
					newProduce.setRight(stringBuilder1.toString());
					
					//添加LR0项目
					this.listNew.add(newProduce);
				}
				
			}
		}
	}
	
	//获得项目集
	public ArrayList<NewProduce> getNewProduce(){
		return this.listNew;
	}
	
	public ArrayList<SignalVn> getListSignalVn(){
		return this.listVn;
	}
	
	public ArrayList<SignalVt> getListSignalVt(){
		return this.listVt;
	}
	
	public ArrayList<ProduceP> getListProduceP(){
		return this.listP;
	}

	public SignalVn getSignalVn() {
		return this.signalVn;
	}
}
