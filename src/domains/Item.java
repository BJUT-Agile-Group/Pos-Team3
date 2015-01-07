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
    protected double vipDiscount;
    public Item(){}

    public Item(String barCode, String name, String unit, double price) {
        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.discount = 1;
        this.promotion=false;
        this.vipDiscount=1;
    }

    public Item(String barCode, String name, String unit, double price,double discount) {

        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.discount = discount;
        this.promotion=false;
        this.vipDiscount=1;
    }

    public Item(String barCode, String name, String unit, double price,boolean promotion) {

        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.discount=1;
        this.promotion=false;
        this.vipDiscount=1;
    }
    public Item(String barCode, String name, String unit, double price,double discount,boolean promotion) {

        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.discount = discount;
        this.promotion = promotion;
        this.vipDiscount=1;
    }

    public Item(String barCode, String name, String unit, double price, double discount, boolean promotion, double vipDiscount) {
        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.discount = discount;
        this.promotion = promotion;
        this.vipDiscount = vipDiscount;
    }

    public boolean isNull()
    {
        return this.barCode==null||barCode.equals("");
    }

    public boolean isRecommended()
    {
        if(discount<1&&promotion==true)
        {
            return false;
        }
        if(vipDiscount<1&&promotion==true)
        {
            return false;
        }
        if(price<0)
        {
            return false;
        }
        return true;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public double getVipDiscount() {
        return vipDiscount;
    }

    public void setVipDiscount(double vipDiscount) {
        this.vipDiscount = vipDiscount;
    }
}
