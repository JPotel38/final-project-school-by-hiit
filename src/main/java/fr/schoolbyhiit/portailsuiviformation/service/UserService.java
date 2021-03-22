package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.controller.exception.UserNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.dto.UserDto;
import fr.schoolbyhiit.portailsuiviformation.entity.model.RoleName;

import java.util.List;

public interface UserService {

    UserDto findById(Long id) throws UserNotFoundException;

    UserDto create(UserDto userDto);

    List<UserDto> findAll();

    UserDto update(Long id, UserDto userDto) throws UserNotFoundException;

    void delete(Long id) throws UserNotFoundException;
}
