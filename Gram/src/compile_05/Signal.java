package compile_05;

/*
  * 抽象字符类
 * 属性：signal表示字符/字符串
 * 抽象方法：getSignal()和setSignal()
 * 分别用于获得属性以及设置属性
 */
interface Signal {
	public String getSignal();

	public void setSignal(String string);
}
