package tw.idv.hunterchen.lab.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_Dom4j {
	private String basePath="/Users/chenhuanzhang/dev/source/java/ex/java_maven_project/target/classes/";
	private String fileXml = basePath + "/tw/idv/hunterchen/lab/xml/sample.xml";
	public void DOM4J_xml() {
		int book_index = 0;
		try {
			SAXReader reader = new SAXReader();						// 建立解析物件
			Document document = reader.read(new File(fileXml));		// 載入xml文件
			Element rootElement = document.getRootElement();		// 得到載入xml文件的根標籤
			Iterator iterator = rootElement.elementIterator();		// 載入跟標籤以下的所有標籤，返回值是一個迭代器物件
			
			// 開始遍歷
			while (iterator.hasNext()) {							// hasNext()的方法，判斷是否還有 子元素, 
				Element book = (Element) iterator.next();			// 獲取 該 element 下的 子元素，
				book_index++;										
				
				showAllAttributes(book);
				Iterator book_node_iter = book.elementIterator();	// 獲取根節點以下的子子節點，
				while (book_node_iter.hasNext()) {// 遍歷所有的子子節點
					Element book_node = (Element) book_node_iter.next();// 獲取子子節點 Element
					System.out.println(book_node.getName() + ":" + book_node.getStringValue());
				} // 獲取標籤名和標籤中的Text值
				System.out.println("============第" + (book_index) + "本結束==========");
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// SAXReader
	// Document
	// Element
	// Attribute
	// XPath表達式 document.selectNodes()d
	// 顯示 元素 的 所有屬性名稱、與值
	public void showAllAttributes(Element element) {
		List<Attribute> attributes = element.attributes();		// 獲取 元素 的全部屬性
		// 逐一取得屬性		
		//法.a
		int index=0;
		for (Attribute attribute : attributes) {
			DevTool.showMessages("屬性", ""+index++, attribute.getName(), attribute.getStringValue(), attribute.getText());
		}
		//法.b
//		for(int i=0; i<attributes.size(); i++) {
//			ShowTool.showMessages("屬性", ""+i, attributes.get(i).getName(), attributes.get(i).getStringValue(), attributes.get(i).getText());
//		}
		
	}

	public static void main(String[] args) {
		 Ex_Dom4j a = new Ex_Dom4j();
         a.DOM4J_xml();
	}
}