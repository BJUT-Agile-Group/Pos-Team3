package domains;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/12/28.
 */
public class Pos {
    public String getShoppingList(ShoppingChart shoppingChart) {
        ArrayList<Item> items = shoppingChart.getItems();
        ArrayList<ShoppingListItem> shoplist = new ArrayList<ShoppingListItem>();
        double total=0;
        double economy=0;

        int i,j;
        for (i = 0; i <items.size() ; i++) {
            if(shoplist.size()==0){
                ShoppingListItem listItem = new ShoppingListItem(items.get(i));
                shoplist.add(listItem);
                total += items.get(i).getPrice()*items.get(i).getDiscount();
                economy += items.get(i).getPrice()*(1-items.get(i).getDiscount());
                continue;
            }

            for (j = 0; j < shoplist.size(); j++) {
                if (shoplist.get(j).getBarCode().equals(items.get(i).getBarCode())){
                    j++;
                    break;
                }
            }
            j--;

            if (shoplist.get(j).getBarCode().equals(items.get(i).getBarCode())){
                shoplist.get(j).setAmount(shoplist.get(j).getAmount()+1);
                shoplist.get(j).setSubTotal(shoplist.get(j).getAmount()*shoplist.get(j).getPrice()
                        *shoplist.get(j).getDiscount());
            }else{
                ShoppingListItem listItem = new ShoppingListItem(items.get(i));
                shoplist.add(listItem);
            }

            total += items.get(i).getPrice()*items.get(i).getDiscount();
            economy += items.get(i).getPrice()*(1-items.get(i).getDiscount());
        }
        items = null;

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder youhui = new StringBuilder();
        youhui.append("----------------------\n挥泪赠送商品:\n");
        stringBuilder.append("***商店购物清单***\n");
        int count =0;
        for (int k = 0; k < shoplist.size(); k++) {
            stringBuilder
                    .append("名称：").append(shoplist.get(k).getName()).append("，")
                    .append("数量：").append(shoplist.get(k).getAmount()).append(shoplist.get(k).getUnit()).append("，")
                    .append("单价：").append(String.format("%.2f", shoplist.get(k).getPrice()))
                    .append("(元)").append("，")
                    .append("小计：").append(String.format("%.2f", shoplist.get(k).getSubTotal()))
                    .append("(元)").append("\n");
            if(shoplist.get(k).getAmount() >= 2&&shoplist.get(k).getpro())
            {
                youhui
                        .append("名称：").append(shoplist.get(k).getName()).append("，")
                        .append("数量：").append("1").append(shoplist.get(k).getUnit()).append("\n");
                count++;
            }
        }
        if(count==0)
        {
            youhui.delete(0,33);
        }
        stringBuilder.append(youhui);
        stringBuilder
                .append("----------------------\n")
                .append("总计：").append(String.format("%.2f", total)).append("(元)").append("\n");
        if(economy!=0) {
            stringBuilder.append("节省：").append(String.format("%.2f", economy)).append("(元)").append("\n");
        }
        stringBuilder.append("**********************\n");


        return stringBuilder.toString();
    }
}
