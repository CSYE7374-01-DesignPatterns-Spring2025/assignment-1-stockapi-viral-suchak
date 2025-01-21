package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;

    private List<StockAPI> stocks = new ArrayList<>();

    private StockMarket(){
        instance = null;
    }

    public static StockMarket getInstance(){
        if(instance == null){
            instance = new StockMarket();
        }
        return instance;
    }

    public StockAPI getStockItem(String name, double price, String description){
        return new StockAPI(name, price, description);
    }

    public void add(StockAPI stock){
        stocks.add(stock);
    }

    public void remove(StockAPI s){
        boolean removed = this.stocks.remove(s);

        if(!removed) {
            System.out.println("Stock not found");
        }
    }

    public void displayStocks(){
        for(StockAPI s : this.stocks){
            System.out.println(s.toString());
        }
    }

    public void updatePrice(StockAPI s, double price){
        if(this.stocks.contains(s)){
            s.setPrice(price);
            return;
        }
        System.out.println("Stock not found");
    }

    public static void demo(){
        System.out.println("");

        GoogleStock googleStock = new GoogleStock(80);
        MetaStock metaStock = new MetaStock(110);

        StockMarket.getInstance().add(googleStock);
        StockMarket.getInstance().add(metaStock);

        googleStock.setBid(10);

        googleStock.setBid(40);

        googleStock.setBid(50);

        googleStock.setBid(60);

        googleStock.setBid(70);

        googleStock.setBid(75);

        googleStock.getMetric();

        /*Meta Stocks*/
        metaStock.setBid(80);

        metaStock.setBid(90);

        metaStock.setBid(100);

        metaStock.setBid(110);

        metaStock.setBid(120);

        metaStock.setBid(130);

        metaStock.getMetric();

        StockMarket.getInstance().displayStocks();
        StockMarket.getInstance().remove(googleStock);
        StockMarket.getInstance().remove(metaStock);
    }
}
