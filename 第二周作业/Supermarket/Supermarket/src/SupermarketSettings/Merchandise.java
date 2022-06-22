package SupermarketSettings;

public class Merchandise {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;


    public Merchandise(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }

    public double CalculateProfit() {
        double profit = soldPrice - purchasePrice;
        if (profit < 0)
            return 0;
        else
            return profit;
    }



    public void describe() {
        System.out.println("商品名为" + name + ",id是" + id + "。" + "商品库存为" + count);
        System.out.println("商品进价为" + purchasePrice + ",商品售价为" + soldPrice + ",商品毛利润为" + (soldPrice - purchasePrice));
    }

    public double buy(int count) {
        if (this.count < count) {
            return -1;
        }
        return this.count -= count;
    }



}
