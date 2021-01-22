package fr.schoolbyhiit.portailsuiviformation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.schoolbyhiit.portailsuiviformation.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query("select name from User where id = :id")
  Optional<String> findNameById(long id);

  List<User> findByName(String name);

}
