package supermarket;

import java.util.Date;

public class Laser extends MerchandiseBeta implements ExpireDateMerchandise {
    private Date produceDate;
    private Date expirationDate;

    private static int Maxpower;

    private static int MaxPRF;

    private static int Wavelength;

    public Laser(String name, String id, int count, double soldPrice, double purchasePrice, Category category,
                 int Maxpower, int MaxPRF, int Wavelength, Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, purchasePrice, category);
        Laser.Maxpower = Maxpower;
        Laser.MaxPRF = MaxPRF;
        Laser.Wavelength = Wavelength;
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;

    }

    public void describeLaser() {
        System.out.println("此激光器商品属性如下");
        System.out.println("最大功率为：" + Maxpower + "W\n" +
                "最高重复频率为:" + MaxPRF + "kHz\n" +
                "波长为：" + Wavelength + "nm\n" );

    }

    @Override
    public Date getProducedDate() {
        return produceDate;
    }

    @Override
    public Date getExpireDate() {
        return expirationDate;
    }

    @Override
    public double actualValueNow(double leftDatePercentage) {
        return super.getSoldPrice();
    }
}