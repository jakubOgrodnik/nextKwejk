package pl.kuba.dao;

import pl.kuba.model.Gif;

import java.util.List;

public interface GifDao {

    void save(Gif gif);
    List<Gif> getAll();
    List<Gif> findByName(String name);
    List<Gif> getFavorites();
    List<Gif> findByCategoryId(int categoryId);
    List<Gif> makeFavorite(boolean favorite);

}
