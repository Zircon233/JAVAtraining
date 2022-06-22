import supermarket.Category;
import supermarket.Laser;
import supermarket.Monster;
import supermarket.Phone;

import java.util.Date;

public class RunAppMain {
    public static void main(String[] args) {

        Date produceDate = new Date();
        Date expireDate = new Date(produceDate.getTime() + 365L * 24 * 3600 * 1000);

        Monster monster = new Monster(
                "Monster Zero", "Drinks001", 1000, 6, 4, Category.DRINKS,
                produceDate, expireDate
        );

        Laser laser = new Laser(
                "PHAROS PH1-20W", "Laser001", 5, 30000, 25000,
                Category.LASER, 20, 200, 1030,produceDate, expireDate
        );

        Phone phone = new Phone(
                "Honor20", "Phone001", 100, 2999, 1999,
                Category.PHONE, 5, 2.8, 8, 256, "HUAWEI", "Android",
                produceDate, expireDate
        );

        System.out.println("---------------" + phone.name + "---------------");
        phone.describe();
        phone.describePhone();
        System.out.println("---------------" + laser.name + "---------------");
        laser.describe();
        laser.describeLaser();
        System.out.println("---------------" + monster.name + "---------------");
        monster.describe();

    }

}
