package vn.codegym.service;
import vn.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    Song findOne(Long id);

    Song update(Song song);

    void save(Song song);

    void remove(Long id);
}
