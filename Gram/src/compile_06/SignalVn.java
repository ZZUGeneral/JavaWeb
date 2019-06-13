package compile_06;

/*
 * 接口类Signal的实现类SignalVn（非终结字符类）
 */
class SignalVn implements Signal{
	
	private String signalVn;
	
	//构造函数初始化
	public SignalVn() {
		this.signalVn="";
	}
	
	public String getSignal() {
		return this.signalVn;
	}
	
	public void setSignal(String string) {
		this.signalVn=string;
	}
}
