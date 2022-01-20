package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Song;

@Repository
public interface ISongRepository extends JpaRepository<Song,Long> {
}
