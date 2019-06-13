package compile_06;

/*
 * 接口类Signal的实现类SignalVt（终结字符类）
 */
class SignalVt implements Signal{
	
	private String signalVt;
	
	//构造函数初始化
	public SignalVt() {
		this.signalVt="";
	}
	
	public String getSignal() {
		return this.signalVt;
	}
	
	public void setSignal(String string) {
		this.signalVt=string;
	}
}
