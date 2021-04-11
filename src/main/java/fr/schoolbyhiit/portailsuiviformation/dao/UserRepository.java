package fr.schoolbyhiit.portailsuiviformation.dao;

import fr.schoolbyhiit.portailsuiviformation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByMail(String mail);
}
