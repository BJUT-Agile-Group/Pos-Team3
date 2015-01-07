package domains;
import com.sun.xml.internal.bind.v2.runtime.output.XmlOutput;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXWriter;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Iterator;

/**
 * Created by HuYijia on 2015/1/7.
 */
public class UsersManager {
    public UsersManager(){}

    public String getUserName() throws Exception
    {
        SAXReader saxReader = new SAXReader();
        Document document;
        document = saxReader.read("index.xml");
        Element root = document.getRootElement();
        Element user=root.element("user");
        return user.getText();
    }

    public int getIntegral(String userName) throws Exception
    {
        SAXReader saxReader = new SAXReader();
        Document document;
        document = saxReader.read("users.xml");
        Element root = document.getRootElement();
        Iterator<Element> iterator = root.elementIterator();

        while (iterator.hasNext()) {
            Element element = iterator.next();

            if (element.attributeValue("type").equals(userName)) {
                return Integer.parseInt(element.elementText("integral"));
            }
        }
        return 0;
    }

    public void increaseIntegral(String userName,int increaseIntegral) throws Exception
    {
        SAXReader saxReader = new SAXReader();
        Document document;
        document = saxReader.read("users.xml");
        Element root = document.getRootElement();
        Iterator<Element> iterator = root.elementIterator();

        while (iterator.hasNext()) {
            Element element = iterator.next();

            if (element.attributeValue("type").equals(userName)) {
                int integral=Integer.parseInt(element.elementText("integral"));
                integral+=increaseIntegral;
                Element integralElement=element.element("integral");
                integralElement.setText(Integer.toString(integral));

                File inputXML=new File("users.xml");
                Writer writer=new FileWriter(inputXML);
                OutputFormat outputFormat=OutputFormat.createPrettyPrint();
                XMLWriter xmlWriter=new XMLWriter(writer,outputFormat);
                xmlWriter.write(document);
                xmlWriter.close();
            }
        }
    }

    public boolean isVIP (String userName) throws Exception
    {
        SAXReader saxReader = new SAXReader();
        Document document;
        document = saxReader.read("users.xml");
        Element root = document.getRootElement();
        Iterator<Element> iterator = root.elementIterator();

        while (iterator.hasNext()) {
            Element element = iterator.next();

            if (element.attributeValue("type").equals(userName)) {
                if (element.elementText("isVIP").equals("true")) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
