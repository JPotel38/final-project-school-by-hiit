package fr.schoolbyhiit.portailsuiviformation.dao;

import fr.schoolbyhiit.portailsuiviformation.entity.Role;
import fr.schoolbyhiit.portailsuiviformation.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName name);

}
