package pl.kuba.dao;

import org.springframework.stereotype.Repository;
import pl.kuba.model.Gif;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class GifDaoImpl implements GifDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Gif gif) {
        entityManager.persist(gif);
    }

    @Override
    @Transactional
    public List<Gif> getAll() {
        return entityManager.createQuery("SELECT p FROM Gif p").getResultList();
    }

    @Override
    @Transactional
    public List<Gif> findByName(String name) {
        Query query = entityManager.createQuery("SELECT p FROM Gif p WHERE p.name='"+name+"'");
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Gif> getFavorites() {
        return entityManager.createQuery("SELECT p FROM Gif p WHERE p.favorite='"+0+"'").getResultList();
    }

    @Override
    @Transactional
    public List<Gif> findByCategoryId(int categoryId) {
        return entityManager.createQuery("SELECT p FROM Gif p WHERE p.categoryId='"+categoryId+"'").getResultList();
    }

    @Override
    @Transactional
    public List<Gif> makeFavorite(boolean favorite) {
        return entityManager.createQuery("UPDATE Gif SET p.favorite='"+1+"' FROM Gif p").getResultList();
    }


}
