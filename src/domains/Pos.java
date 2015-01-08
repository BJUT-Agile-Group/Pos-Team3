package domains;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
* Created by Administrator on 2014/12/28.
*/
public class Pos {
    public Pos() {}

    public String getShoppingList(ShoppingListChart shoppingListChart) throws Exception{
        ArrayList<ListItem> listItems = shoppingListChart.getListItems();
        double totalMoney = 0;
        double totalSaveMoney = 0;

        UsersManager usersManager=new UsersManager();
        if(usersManager.isVIP(usersManager.getUserName()))
        {
          for(int i=0;i<listItems.size();i++)
          {
              Double subTotal=listItems.get(i).getSubTotal();
              Double saveMoney=listItems.get(i).getSaveMoney();
              saveMoney+=subTotal*(1-listItems.get(i).getVipDiscount());
              subTotal=subTotal*listItems.get(i).getVipDiscount();
              listItems.get(i).setSubTotal(subTotal);
              listItems.get(i).setSaveMoney(saveMoney);
          }
        }

        for (int i = 0; i < listItems.size(); i++) {
            totalMoney += listItems.get(i).getSubTotal();
            totalSaveMoney += listItems.get(i).getSaveMoney();
        }

        if(usersManager.getIntegral(usersManager.getUserName())>=0&&usersManager.getIntegral(usersManager.getUserName())<=200) {
            usersManager.increaseIntegral(usersManager.getUserName(),(int)(totalMoney/5));
        }
        else if(usersManager.getIntegral(usersManager.getUserName())>200&&usersManager.getIntegral(usersManager.getUserName())<=500)
        {
            usersManager.increaseIntegral(usersManager.getUserName(),(3*(int)(totalMoney/5)));
        }
        else if(usersManager.getIntegral(usersManager.getUserName())>500)
        {
            usersManager.increaseIntegral(usersManager.getUserName(),(5*(int)(totalMoney/5)));
        }

        StringBuilder stringBuilder = new StringBuilder();

        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
        String currentTime=simpleDateFormat.format(calendar.getTime());
        stringBuilder
                .append("***商店购物清单***\n")
                .append("会员编号："+usersManager.getUserName()+"    会员积分："+usersManager.getIntegral(usersManager.getUserName())+"\n")
                .append("----------------------\n")
                .append("打印时间：" + currentTime + "\n")
                .append("----------------------\n");

        for (int i = 0; i < listItems.size(); i++) {
            stringBuilder
                    .append("名称：").append(listItems.get(i).getName()).append("，");
            if(listItems.get(i).canBePromotion()) {
                stringBuilder
                    .append("数量：").append(listItems.get(i).getAmount()+1).append(listItems.get(i).getUnit()).append("，");
            }
            else
            {
                stringBuilder
                        .append("数量：").append(listItems.get(i).getAmount() ).append(listItems.get(i).getUnit()).append("，");
            }

            stringBuilder
                    .append("单价：").append(String.format("%.2f", listItems.get(i).getPrice()));

            stringBuilder
                    .append("(元)").append("，")
                    .append("小计：").append(String.format("%.2f", listItems.get(i).getSubTotal()))
                    .append("(元)").append("\n");
        }

        if (shoppingListChart.isPromotion()) {
            stringBuilder
                    .append("----------------------\n挥泪赠送商品:\n");
            for (int i = 0; i < listItems.size(); i++) {

                if (listItems.get(i).canBePromotion()) {
                    totalSaveMoney+=listItems.get(i).getPrice();
                    stringBuilder
                            .append("名称：").append(listItems.get(i).getName()).append("，")
                            .append("数量：").append("1").append(listItems.get(i).getUnit()).append("\n");
                }
            }
        }

        stringBuilder
                .append("----------------------\n")
                .append("总计：").append(String.format("%.2f", totalMoney)).append("(元)").append("\n");
        if(totalSaveMoney!=0) {
            stringBuilder.append("节省：").append(String.format("%.2f", totalSaveMoney)).append("(元)").append("\n");
        }
        stringBuilder.append("**********************\n");

        return stringBuilder.toString();
    }
}