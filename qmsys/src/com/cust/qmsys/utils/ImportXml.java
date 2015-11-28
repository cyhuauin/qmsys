package com.cust.qmsys.utils;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import com.cust.qmsys.domain.Userprofession;
public class ImportXml {
	String xmlfilename = null;
	List list = new ArrayList();
	Userprofession upro = null;

	public ArrayList getProfession() {
		try {
			xmlfilename = this.getClass().getClassLoader().getResource("/")
					.toURI().getPath()
					+ "/WEB-INF/Messages.xml";
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			org.w3c.dom.Document doc = db.parse(xmlfilename);
			NodeList nl = doc.getElementsByTagName("profession");
			for (int i = 0; i < nl.getLength(); i++) {
				org.w3c.dom.Element n = (org.w3c.dom.Element) nl.item(i);
				NodeList l1 = n.getElementsByTagName("id");
				NodeList l2 = n.getElementsByTagName("name");
				upro = new Userprofession();
				int id = Integer.parseInt(l1.item(0).getFirstChild()
						.getNodeValue());
				String name = l2.item(0).getFirstChild().getNodeValue();
				upro.setID(id);
				upro.setName(name);
				list.add(upro);
			}
			return (ArrayList) list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}
}