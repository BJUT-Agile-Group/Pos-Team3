package domains;

/**
 * Created by Administrator on 2014/12/28.
 */
public class Item {
    protected String barCode;
    protected String name;
    protected String unit;
    protected double price;
    protected double discount;
    protected boolean promotion;
    public Item(){}

    public Item(String barCode, String name, String unit, double price) {

        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.discount = 1;
    }
    public Item(String barCode, String name, String unit, double price,double discount) {

        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.discount = discount;
    }
    public Item(String barCode, String name, String unit, double price,double discount,boolean promotion) {

        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.discount = discount;
        this.promotion = promotion;
    }
    public double getDiscount() {
        return discount;
    }
    public String getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }
    public boolean getpro()
    {
        return promotion;
    }
    public double getPrice() {
        return price;
    }
}
