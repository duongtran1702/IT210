package atmin.b2.service;

import atmin.b2.model.Dish;
import org.springframework.stereotype.Service; // Thêm cái này

import java.util.*;

@Service
public class DishService {
    private final List<Dish> list = new ArrayList<>(
            List.of(new Dish(1, "Pho", 30000, true),
                    new Dish(2, "Bun Cha", 40000, false))
    );

    public List<Dish> getAll() {
        return list;
    }

    public Dish findById(int id) {
        return list.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(Dish updatedDish) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == updatedDish.getId()) {
                list.set(i, updatedDish); // Thay thế phần tử cũ bằng phần tử mới
                return;
            }
        }
    }
}