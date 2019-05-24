package compile_05;

import java.util.ArrayList;

class ProduceP {
	
	private SignalVn leftProduce;
	private ArrayList<String[]> rightProduce;
	
	public ProduceP() {
		this.leftProduce=new SignalVn();
		this.rightProduce=new ArrayList<String[]>();
	}
	
	public void setProduce(String string) {
		String[] tempStr=string.split(" ");
		for(int i=0; i<tempStr.length; i++) {
			if(i==0) {
				this.leftProduce.setSignal(tempStr[i]);
			}else{
				String[] str=new String[tempStr[i].length()];
				for(int j=0, length=tempStr[i].length();j<length;j++) {
					str[j]=tempStr[i].substring(j, j+1);
				}
				this.rightProduce.add(str);
			}
		}
	}
	
	public SignalVn getLeftProduce() {
		return this.leftProduce;
	}
	
	public ArrayList<String[]> getRightProduce(){
		return this.rightProduce;
	}

	public String showProduce() {
		String produce="";
		produce=produce+this.leftProduce.getSignal()+"->";
		for(int i=0,length=this.rightProduce.size();i<length;i++) {
			if(i==length-1) {
				for(int j=0;j<this.rightProduce.get(i).length;j++) {
					produce=produce+this.rightProduce.get(i)[j];
				}
				
			}else {
				for(int j=0;j<this.rightProduce.get(i).length;j++) {
					produce=produce+this.rightProduce.get(i)[j];
				}
				produce=produce+"|";
			}
		}
		return produce;
	}
}
