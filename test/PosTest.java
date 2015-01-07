import domains.Item;
import domains.Pos;
import domains.ShoppingChart;
import domains.ShoppingListChart;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
* Created by Administrator on 2014/12/28.
*/
public class PosTest {
    @Test
    public void testGetCorrectShoppingListForSingleItem() throws Exception {
        // given
        Item cokeCola = new Item("ITEM000000", "可口可乐", "瓶", 3.00);
        ShoppingChart shoppingChart = new ShoppingChart();
        shoppingChart.add(cokeCola);

        // when
        ShoppingListChart shoppingListChart = new ShoppingListChart(shoppingChart);
        Pos pos = new Pos();
        String result = pos.getShoppingList(shoppingListChart);

        // then
        String expectedShoppingList =
                          "***商店购物清单***\n"
                        + "名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        + "----------------------\n"
                        + "总计：3.00(元)\n"
                        + "**********************\n";
        assertThat(result, is(expectedShoppingList));
    }

//    @Test
//    public void testGetCorrectShoppingListForTwoSameItems() throws Exception {
//        // given
//        ShoppingChart shoppingChart = new ShoppingChart();
//        shoppingChart.add(new Item("ITEM000005", "吹风机", "件", 83.00));
//        shoppingChart.add(new Item("ITEM000005", "吹风机", "件", 83.00));
//
//        // when
//        Pos pos = new Pos();
//        String actualShoppingList = pos.getShoppingList(shoppingChart);
//
//        // then
//        String expectedShoppingList =
//                          "***商店购物清单***\n"
//                        + "名称：吹风机，数量：2件，单价：83.00(元)，小计：166.00(元)\n"
//                        + "----------------------\n"
//                        + "总计：166.00(元)\n"
//                        + "**********************\n";
//        assertThat(actualShoppingList, is(expectedShoppingList));
//    }
//
//    @Test
//    public void testGetCorrectShoppingListForReq1() throws Exception {
//        //given
//        ShoppingChart shoppingChart = new ShoppingChart();
//        shoppingChart.add(new Item("ITEM000000","可口可乐","瓶",3.00));
//        shoppingChart.add(new Item("ITEM000000","可口可乐","瓶",3.00));
//        shoppingChart.add(new Item("ITEM000000","可口可乐","瓶",3.00));
//        shoppingChart.add(new Item("ITEM000000","可口可乐","瓶",3.00));
//        shoppingChart.add(new Item("ITEM000000","可口可乐","瓶",3.00));
//        shoppingChart.add(new Item("ITEM000001","雪碧","瓶",3.00));
//        shoppingChart.add(new Item("ITEM000001","雪碧","瓶",3.00));
//        shoppingChart.add(new Item("ITEM000004","电池","个",2.00));
//
//        //when
//        Pos pos = new Pos();
//        String actualShoppingList = pos.getShoppingList(shoppingChart);
//
//        //then
//        String expectedShoppingList =
//                "***商店购物清单***\n"
//                        + "名称：可口可乐，数量：5瓶，单价：3.00(元)，小计：15.00(元)\n"
//                        + "名称：雪碧，数量：2瓶，单价：3.  元)，小计：6.00(元)\n"
//                        + "名称：电池，数量：1个，单价：2.00(元)，小计：2.00(元)\n"
//                        + "----------------------\n"
//                        + "总计：23.00(元)\n"
//                        + "**********************\n";
//        assertThat(actualShoppingList, is(expectedShoppingList));
//
//    }
//
//    @Test
//    public void testGetCorrectShoppingListForReq2() throws Exception {
//        //given
//        ShoppingChart shoppingChart = new ShoppingChart();
//        shoppingChart.add(new Item("ITEM000004","电池","个",2.00,0.8));
//
//        //when
//        Pos pos = new Pos();
//        String actualShoppingList = pos.getShoppingList(shoppingChart);
//
//        //then
//        String expectedShoppingList =
//                "***商店购物清单***\n"
//                        + "名称：电池，数量：1个，单价：2.00(元)，小计：1.60(元)\n"
//                        + "----------------------\n"
//                        + "总计：1.60(元)\n"
//                        + "节省：0.40(元)\n"
//                        + "**********************\n";
//        assertThat(actualShoppingList, is(expectedShoppingList));
//
//    }
}