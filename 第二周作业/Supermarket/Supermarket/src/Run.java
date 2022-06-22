import SupermarketSettings.*;

public class Run {
    public static void main(String[] args) {
        // 创建一个小超市类
        Supermarket supermarket = new Supermarket(
                "兴华", "西安",
                150, 100, 200);
        System.out.println("利润最高的商品为");
        supermarket.getBiggestProfitMerchandise().describe();
    }
}
