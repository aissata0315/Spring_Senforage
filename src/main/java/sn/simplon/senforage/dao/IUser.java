package sn.simplon.senforage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.simplon.senforage.entities.User;

@Repository
public interface IUser  extends JpaRepository<User, Integer> {
    @Query(name="Select u from User u where u.email=:email and u.password=:password")
    public User getUserByEmailAndPassword(@Param("em") String email, @Param("pw") String password);
}
