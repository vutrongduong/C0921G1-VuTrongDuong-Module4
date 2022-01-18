package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.repository.ISongRepository;
import vn.codegym.model.Song;

import java.util.List;
public class SongServiceImpl implements ISongService {
    @Autowired
    private ISongRepository repository;
    @Override
    public List<Song> findAll() {
        return repository.findAll();
    }

    @Override
    public Song findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void save(Song song) {
        repository.save(song);
    }

    @Override
    public void remove(Long id) {
        repository.remove(id);
    }
}