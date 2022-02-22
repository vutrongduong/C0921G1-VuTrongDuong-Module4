package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName(String username);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "insert into user_role value (:user ,:role);", nativeQuery = true)
    void addRole(@Param("user") String user, @Param("role") Integer role);
}
