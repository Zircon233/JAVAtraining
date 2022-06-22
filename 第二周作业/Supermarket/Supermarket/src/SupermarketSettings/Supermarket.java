package SupermarketSettings;
import java.text.DecimalFormat;

public class Supermarket {

    public String superMarketName;
    public String address;
    public int parkingCount;

    public Merchandise[] merchandises;
    public int[] merchandiseSold;

    public Supermarket(String superMarketName, String address, int parkingCount,
                       int merchandiseCount, int count) {
        this.superMarketName = superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;
        DecimalFormat df= new DecimalFormat("#.000");
        merchandises = new Merchandise[merchandiseCount];

        for (int i = 0; i < merchandises.length; i++) {
            double purchasePrice = Double.parseDouble(df.format(Math.random() * 200));
            // 创建并给商品的属性赋值
            Merchandise m = new Merchandise(
                    "商品" + i,
                    "ID" + i,
                    count,
                    Double.parseDouble(df.format(purchasePrice * (1 + Math.random()))),
                    purchasePrice
            );
            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            merchandises[i] = m;
        }
        merchandiseSold = new int[merchandises.length];
    }


    public  Merchandise getBiggestProfitMerchandise() {
        Merchandise curr = null;
        //若有多个相同最大利润，记录的是靠前的商品编号
        for (int i = 0; i < merchandiseSold.length; i++) {
            Merchandise m = merchandises[i];
            if (curr == null)
                curr = m;
            else {
                if (curr.CalculateProfit() < m.CalculateProfit()) {
                    curr = m;
                }
            }
        }
        int cnt = 0;
        int[] record = new int[merchandiseSold.length];

        //  判断是否有多个相同最大利润
        for (int i = 0; i < merchandiseSold.length; i++) {
            Merchandise m = merchandises[i];
            if (curr.CalculateProfit() == m.CalculateProfit()) {
                record[cnt] = i;
                cnt++;
            }
        }
        String display = "";
        for (int i = 0; i < cnt; i++) {
            display += record[i];
            display += ' ';
        }
        if (cnt == 1)
            System.out.println("利润最大商品为" + display+"号商品。");
        else
            System.out.println("有" + cnt + "个相同最大利润商品,其商品标号为" + display);

        return curr;
    }

}