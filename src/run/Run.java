package run;

import domains.Item;
import domains.Pos;
import domains.ShoppingChart;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Hugh on 2014/12/29 0029.
 */
public class Run {
    public static void main(String[] args)throws IOException{
        int x;
        Scanner input=new Scanner(System.in);
        Run run=new Run();
        Pos pos = new Pos();
        ShoppingChart shoppingChart = new ShoppingChart();
        run.menuList();
        System.out.println("输入你的选择：");
        x=input.nextInt();
        while(1<=x&&x<=3){
        if(x==1) {
            Item cokeCola = new Item("ITEM000000", "可口可乐", "瓶", 3.00);
            shoppingChart.add(cokeCola);
        }
        if(x==2) {
            Item cokeCola = new Item("ITEM000001", "雪碧", "瓶", 3.00);
            shoppingChart.add(cokeCola);
        }
        if(x==3) {
            Item cokeCola = new Item("ITEM000004", "电池", "个", 2.00);
            shoppingChart.add(cokeCola);
        }
            System.out.println("\n \n \n");
            run.menuList();
            System.out.println("购物车中已有" + shoppingChart.getItems().size()+"件商品");
            System.out.print("输入你的选择：");
            x=input.nextInt();
        }
        if(x==4){
            System.out.println("\n \n \n");
            String actualShoppingList = pos.getShoppingList(shoppingChart);
            System.out.println(actualShoppingList);
        }
    }
    public void menuList(){
        System.out.println("1.ITEM000000 可口可乐  瓶 3.00");
        System.out.println("2.ITEM000001 雪碧      瓶 3.00");
        System.out.println("3.ITEM000004 电池      个 2.00");
        System.out.println("4.打印账单");
    }
}
