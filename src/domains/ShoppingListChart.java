package domains;

import java.util.ArrayList;

/**
 * Created by HuYijia on 2015/1/5.
 */
public class ShoppingListChart {
    private ArrayList<ListItem> listItems=new ArrayList<ListItem>();
    private boolean hasPromotion=false;

    public  ShoppingListChart(){}

    public ShoppingListChart(ShoppingChart shoppingChart){
        ArrayList<Item> items=shoppingChart.getItems();

        for(int i=0;i<items.size();i++)
        {
            Item item=items.get(i);

            if(!this.hasThisProduct(item.getBarCode()))
            {
                ListItem listItem=new ListItem(item);
                listItems.add(listItem);
            }
            else
            {
                for(int j=0;j<listItems.size();j++)
                {
                    if(listItems.get(j).getBarCode().equals(item.getBarCode()))
                    {
                        listItems.get(j).create();
                    }
                }
            }
        }

        chargePromotion();
    }

    public void chargePromotion()
    {
        for(int i=0;i<listItems.size();i++)
        {
            if(listItems.get(i).canBePromotion())
            {
                this.hasPromotion=true;
            }
        }
    }

    public boolean hasThisProduct(String barCode)
    {
        for(int i=0;i<listItems.size();i++)
        {
            ListItem listItem=listItems.get(i);
            if(listItem.getBarCode().equals(barCode))
            {
                return true;
            }
        }
        return false;
    }

    public ArrayList<ListItem> getListItems() {
        return listItems;
    }

    public void setListItems(ArrayList<ListItem> listItems) {
        this.listItems = listItems;
    }

    public  boolean isPromotion()
    {
        return  hasPromotion;
    }
}
