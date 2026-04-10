package atmin.b2.model;

import java.beans.ConstructorProperties;

public class Dish {
     int id;
     String name;
     double price;
     boolean isAvailable;

    @ConstructorProperties({"id", "name", "price", "available"})
    public Dish(int id, String name, double price, boolean available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvailable = available;
    }

    // Đừng quên Constructor không đối số và Getter/Setter
    public Dish() {}

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return isAvailable; }
}