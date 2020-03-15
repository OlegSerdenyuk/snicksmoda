package ua.com.snicksmoda.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.snicksmoda.entity.Category;

@Service
public class CategoryService {

    @Transactional
    public Category getCategoryByName(String name) {
        Category category = null;
        if (name.equals("mens clothing")) {
            category = Category.MENS_CLOTHING;
        } else if (name.equals("womens clothing")) {
            category = Category.WOMENS_CLOTHING;
        } else  if (name.equals("baby clothing")) {
            category = Category.BABY_CLOTHING;
        }
        return category;
    }
}
