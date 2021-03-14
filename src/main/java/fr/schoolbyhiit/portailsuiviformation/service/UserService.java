package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto findById(Long id);

    UserDto create(UserDto userDto);

    List<UserDto> findAll();

    UserDto update(Long id, UserDto userDto);

    void delete(Long id);
}
