package fr.schoolbyhiit.portailsuiviformation.dao;

import static org.assertj.core.groups.Tuple.tuple;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.schoolbyhiit.portailsuiviformation.entity.User;

@SpringBootTest
public class UserRepositoryTest {

    private static final String CHUCK_NORRIS_NAME = "Chuck Norris";
    private static final long CHUCK_NORRIS_ID = 42;


    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldFindChuckNorrisByHisId() {
        Assertions.assertThat(userRepository.findNameById(CHUCK_NORRIS_ID)).contains(
                CHUCK_NORRIS_NAME
        );
    }

    @Test
    public void shouldFindChuckNorrisByHisName() {
        Assertions.assertThat(userRepository.findByName(CHUCK_NORRIS_NAME)).extracting(
                User::getId, User::getName
        ).containsOnly(
                tuple(CHUCK_NORRIS_ID, CHUCK_NORRIS_NAME)
        );
    }
}