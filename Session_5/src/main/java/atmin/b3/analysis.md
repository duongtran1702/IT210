## 3. Yêu cầu & 4. Đầu ra (Bài 3)

### I. Báo cáo phân tích

Luồng dữ liệu (Data Flow):
- Người dùng click nút "Edit" ở View A (dish-list)
- Gửi request: /bai3/edit/{id}
- Controller nhận ID
- Gọi Service để lấy Dish theo id
- Nếu tồn tại → đưa vào Model → trả về View B (edit-dish.html)
- Nếu không tồn tại → redirect về danh sách + thông báo lỗi

Binding dữ liệu:
- Sử dụng th:object="${dish}"
- Các field dùng th:field="*{...}" để bind dữ liệu

Tạo đường dẫn động:
- Dùng @{} với biến:
  /bai3/edit/{id}
- Ví dụ:
  th:href="@{'/bai3/edit/' + ${d.id}}"

Xử lý lỗi:
- Nếu không tìm thấy Dish:
  → redirect:/bai2/dish-list
  → model.addAttribute("error", "Không tìm thấy món ăn yêu cầu!")

---

### II. Source Code

#### 1. bai3/AdminDishService.java
```java
package bai3;

import common.Dish;
import java.util.*;

public class AdminDishService {
    private List<Dish> list = new ArrayList<>();

    public AdminDishService() {
        list.add(new Dish(1, "Pho", 30000, true));
        list.add(new Dish(2, "Bun Cha", 40000, false));
    }

    public Dish findById(int id) {
        for (Dish d : list) {
            if (d.getId() == id) return d;
        }
        return null;
    }
}