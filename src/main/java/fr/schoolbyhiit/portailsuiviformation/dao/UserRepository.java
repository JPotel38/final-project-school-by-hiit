package fr.schoolbyhiit.portailsuiviformation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.schoolbyhiit.portailsuiviformation.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findById(long id);

}
