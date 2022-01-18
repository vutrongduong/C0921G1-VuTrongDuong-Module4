package vn.codegym.repository;

import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.Song;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class SongRepositoryImpl implements ISongRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Song> findAll() {
        String queryStr = "SELECT s FROM Song AS s";
        TypedQuery<Song> query = em.createQuery(queryStr, Song.class);
        return query.getResultList();
    }

    @Override
    public Song findOne(Long id) {
        String queryStr = "SELECT s FROM Song AS s WHERE s.id = :id";
        TypedQuery<Song> query = em.createQuery(queryStr, Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Song save(Song song) {
        if (song.getId() != null) {
            em.merge(song);
        } else {
            em.persist(song);
        }
        return song;
    }

    @Override
    public void remove(Long id) {
        Song song = findOne(id);
        if (song != null) {
            em.remove(song);
        }
    }
}
