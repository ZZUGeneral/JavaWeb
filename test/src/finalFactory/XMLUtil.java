package finalFactory;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtil {
	public static Object getBean() {
		try {
			// �����ĵ�����
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("config.xml"));
			// ��ȡ����ͼ�����͵��ı��ڵ�
			NodeList nl = doc.getElementsByTagName("flagFactory");
			Node classNode = nl.item(0).getFirstChild();
			String fName = classNode.getNodeValue().trim();

			// ͨ����������ʵ�����󲢽��䷵��
			Class c = Class.forName(fName);
			Object obj = c.newInstance();

			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
