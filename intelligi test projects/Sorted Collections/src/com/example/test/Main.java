package com.example.test;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args)
    {
        StockItem temp = new StockItem("braed" , 0.86 , 100);
        stockList.addStock(temp);
        temp = new StockItem("cake", 1.10 , 7);
        stockList.addStock(temp);
        temp = new StockItem("car", 12.5 , 2);
        stockList.addStock(temp);
        temp = new StockItem("chair", 52.0 , 10);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.50 , 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45 , 7);
        stockList.addStock(temp);
        temp = new StockItem("door", 72.95 , 4);
        stockList.addStock(temp);
        temp = new StockItem("juice", 2.50 , 36);
        stockList.addStock(temp);
        temp = new StockItem("phone", 96.99 , 35);
        stockList.addStock(temp);
        temp = new StockItem("towel", 2.40 , 80);
        stockList.addStock(temp);
        temp = new StockItem("vase", 8.67 , 40);
        stockList.addStock(temp);

        System.out.println(stockList.toString());

        for (String s : stockList.Items().keySet())
        {
            System.out.println(s);
        }

        Basket timsBasket = new Basket("Tim");
        sellItem(timsBasket , "car" , 1);
        System.out.println(timsBasket);
        sellItem(timsBasket , "car" , 1);
        System.out.println(timsBasket);
        sellItem(timsBasket , "car" , 1);
        sellItem(timsBasket , "spanner" , 1);
        //System.out.println(timsBasket);
        sellItem(timsBasket , "juice",4);
        sellItem(timsBasket , "cup",12);
        sellItem(timsBasket , "bread" , 1);
        //System.out.println(timsBasket);
       // System.out.println(stockList);
        Basket basket =new Basket("customer");
        sellItem(basket,"cup",100);
        sellItem(basket , "juice", 5);
        removeItem(basket , "cup" , 1);
        System.out.println(basket);
        removeItem(timsBasket , "car" , 1);
        removeItem(timsBasket, "cup",1);
        removeItem(timsBasket , "car", 1);
        System.out.println("cars removed : "+removeItem(timsBasket , "car",1));
        System.out.println(timsBasket);
        removeItem(timsBasket , "bread",1);
        removeItem(timsBasket , "cup",3);
        removeItem(timsBasket , "juice",4);
        removeItem(timsBasket , "cup",3);

        System.out.println(timsBasket);
        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(timsBasket);
        System.out.println(timsBasket);

        /*for (Map.Entry<String , Double> price :stockList.PriceList().entrySet())
        {
            System.out.println(price.getKey()+" costs "+price.getValue());
        }*/
    }
    public static int sellItem(Basket basket , String item , int quantity)
    {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null)
        {
            System.out.println("we don't sell "+item);
            return 0;
        }
        if (stockList.reserveStock(item, quantity) != 0)
        {
            return basket.addToBasket(stockItem , quantity);
        }
        return 0;
    }
    public static int removeItem(Basket basket , String item , int quantity)
    {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null)
        {
            System.out.println("we don't sell "+item);
            return 0;
        }
        if (basket.removeFromBasket(stockItem, quantity) == quantity)
        {
            return stockList.unreserveStock(item , quantity);
        }
        return 0;
    }
    public static void checkOut(Basket basket)
    {
        for (Map.Entry<StockItem , Integer> item : basket.items().entrySet())
        {
            stockList.sellStock(item.getKey().getName() , item.getValue());
        }
        basket.clearBasket();;
    }
}
