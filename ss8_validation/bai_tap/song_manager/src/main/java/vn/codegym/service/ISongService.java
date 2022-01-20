package vn.codegym.service;

import org.springframework.stereotype.Service;
import vn.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void add(Song song);

    void edit(Song song);
    Song findById(Long id);
}
