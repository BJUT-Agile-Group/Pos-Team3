package run;

import domains.*;
//import domains.Pos;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
/**
 * Created by Hugh on 2014/12/29 0029.
 */
public class Run {
    public static void main(String[] args) throws Exception {
        Run run = new Run();
        ShoppingChart shoppingChart = run.saxIndex();
        ShoppingListChart shoppingListChart = new ShoppingListChart(shoppingChart);
        Pos pos = new Pos();
        String result = pos.getShoppingList(shoppingListChart);
        System.out.println(result);

    }

    /*
    功能：根据索引表导出购物清单，该函数依赖于saxListing
    参数：无
    返回值：购物车清单ShoppingChart，若读取时出错，则跳过该清单并提示出错的编码barCode
    */
    public ShoppingChart saxIndex() throws  Exception
    {
        ShoppingChart shoppingChart=new ShoppingChart();
        SAXReader saxReader = new SAXReader();
        Document document;
        document = saxReader.read("index.xml");
        Element root = document.getRootElement();
        Element goods=root.element("goods");
        Iterator<Element> iterator = goods.elementIterator();

        while (iterator.hasNext()) {
            Element element=iterator.next();
            String barCode=element.getText();
            Item item=saxListing(barCode);
            if(!item.isRecommended())
            {
                System.out.println("Discount and promotion can't exist both, barCode: "+item.getBarCode());
            }
            if(!item.isNull()){
                shoppingChart.add(item);
            }else {
                System.out.println("Read error,item barcode: " + barCode);
            }
        }
        return  shoppingChart;
    }

    /*
    功能：根据产品编码从产品列表中寻找相应的产品，返回该商品属性Item
    参数：String bacCord 产品的编码
    返回值：Item  若成功，则返回该产品属性，否则，返回空Item
     */
    public Item saxListing(String bacCode) throws DocumentException{
        SAXReader saxReader = new SAXReader();
        Document document;
        document = saxReader.read("listing.xml");
        Element root = document.getRootElement();
        Iterator<Element> iterator = root.elementIterator();

        while (iterator.hasNext()) {
            Element element = iterator.next();

            if(element.attributeValue("type").equals(bacCode)){
                String name=element.elementText("name");
                String unit=element.elementText("unit");
                double price=Double.parseDouble(element.elementText("price"));
                double discount=Double.parseDouble(element.elementText("discount"));
                boolean promotion = Boolean.parseBoolean(element.elementText("promotion"));
                double vipDiscount=Double.parseDouble(element.elementText("vipDiscount"));
                return new Item(bacCode,name,unit,price,discount,promotion,vipDiscount);
            }
        }
        return new Item();
    }
}
