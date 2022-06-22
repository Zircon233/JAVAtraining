package supermarket;

public enum Category {

    FOOD(1),
    LASER(3),
    DRINKS(5),

    PHONE(7);



    private int id;

    Category(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                '}';
    }

}
