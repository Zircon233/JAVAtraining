package supermarket;

import java.util.Date;


public class Monster extends MerchandiseBeta implements ExpireDateMerchandise {
    private Date produceDate;
    private Date expirationDate;


    public Monster(String name, String id, int count, double soldPrice, double purchasePrice, Category category, Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, purchasePrice,category);
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
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