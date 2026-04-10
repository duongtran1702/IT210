package atmin.btth.model;

public class Dish {
    int id;
    String name;
    double originalPrice;
    int discountPercent;
    static int autoId = 0;

    public Dish(String name, double originalPrice, int discountPercent) {
        this.id = ++autoId;
        this.name = name;
        this.originalPrice = originalPrice;
        this.discountPercent = discountPercent;
    }


    public String getName() {
        return name;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}
