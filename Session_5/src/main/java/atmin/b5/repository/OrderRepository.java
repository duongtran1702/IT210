package atmin.b5.repository;

import atmin.b2.model.Dish;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private static final List<Dish> dishes = new ArrayList<>();

    static {
        dishes.add(new Dish(1, "Phở Bò", 55000, true));
        dishes.add(new Dish(2, "Bún Chả", 45000, true));
    }

    public Dish findById(int id) {
        return dishes.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }
}