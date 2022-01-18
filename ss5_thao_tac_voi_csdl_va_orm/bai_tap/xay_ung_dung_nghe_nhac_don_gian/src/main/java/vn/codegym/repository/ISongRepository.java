package vn.codegym.repository;

import vn.codegym.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();

    Song findOne(Long id);

    Song save(Song song);

    void remove(Long id);
}
