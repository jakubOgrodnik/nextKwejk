package pl.kuba.dao;

import org.springframework.stereotype.Repository;
import pl.kuba.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveCategory(Category category) {
        entityManager.persist(category);
    }

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        return entityManager.createQuery("SELECT p FROM Category p").getResultList();
    }

    @Override
    @Transactional
    public List<Category> findById(int id) {
        return entityManager.createQuery("select g, p.categoryName from Gif g, Category p where g.categoryId='"+id+"' AND p.id='"+id+"'").getResultList();
    }
}
