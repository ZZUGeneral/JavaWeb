package compile_06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileProcess {
	
	private String stringVn;
	private String stringVt;
	private String stringS;
	private ArrayList<String> stringP;
	
	public FileProcess() {
		this.stringVn="";
		this.stringVt="";
		this.stringS="";
		this.stringP=new ArrayList<String>();
	}
	
	public void fileProcess(String fileName) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			String tempString = null;
			//循环文件以行的形式读取数据
			while ((tempString = reader.readLine()) != null) {
				//读取非终结符的内容
				if("Vn".equals(tempString)) {
					if((tempString = reader.readLine()) != null) {			
						this.stringVn = reader.readLine();
					}
				}
				//读取终结符的内容
				if("Vt".equals(tempString)) {
					if((tempString = reader.readLine()) != null) {
						this.stringVt = reader.readLine();
					}
				}
				//读取产生式的内容
				if("P".equals(tempString)) {
					if((tempString = reader.readLine()) != null) {
						int count=Integer.parseInt(tempString);
						for(int i=0;i<count;i++) {
							this.stringP.add(reader.readLine());
						}
					}
				}
				//读取开始符
				if("S".equals(tempString)) {
					if((tempString = reader.readLine()) != null) {
						this.stringS=tempString;
					}
				}
			}
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	
	public String getStringVn() {
		return this.stringVn;
	}
	
	public String getStringVt() {
		return this.stringVt;
	}
	
	public ArrayList<String> getStringP() {
		return this.stringP;
	}
	
	public String getStringS() {
		return this.stringS;
	}
}
