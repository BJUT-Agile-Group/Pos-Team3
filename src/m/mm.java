package m;

import domains.Item;
import domains.Pos;
import domains.ShoppingChart;

/**
 * Created by Hugh on 2014/12/29 0029.
 */
public class mm {
    public static void main(String[] args){
        Item cokeCola = new Item("ITEM000000", "可口可乐", "瓶", 3.00);
        ShoppingChart shoppingChart = new ShoppingChart();
        shoppingChart.add(cokeCola);

        // when
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);
        System.out.println(actualShoppingList);
    }
}
