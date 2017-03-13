package pl.kuba.dao;

import pl.kuba.model.Category;

import java.util.List;

public interface CategoryDao {

    void saveCategory(Category category);
    List<Category> getAllCategories();
    List<Category> findById(int id);
}
