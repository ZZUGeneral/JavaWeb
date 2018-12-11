package finalBridge;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;

public class XMLUtil {
	public static java.lang.Object getBean(String str) {
		try {
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("config.xml"));
			NodeList nl = null;
			Node classNode = null;

			String cName = null;
			nl = doc.getElementsByTagName("className");
			if (str.equals("WenBen")) {
				classNode = nl.item(0).getFirstChild();
			} else if (str.equals("Reader")) {
				classNode = nl.item(1).getFirstChild();
			}
			cName = classNode.getNodeValue();
			Class c = Class.forName(cName);
			Object obj = c.newInstance();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}