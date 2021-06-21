package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.exception.EmailExistsException;
import fr.schoolbyhiit.portailsuiviformation.exception.UserNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.dao.UserRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.UserDto;
import fr.schoolbyhiit.portailsuiviformation.entity.User;
import fr.schoolbyhiit.portailsuiviformation.mapper.UserMapper;
import fr.schoolbyhiit.portailsuiviformation.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto create(UserDto userDto) {
        if(userRepository.getUserByMail(userDto.getMail()).isPresent()){
            throw new EmailExistsException(userDto.getMail());
        }
        if(StringUtils.isBlank(userDto.getMail())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        userDto.setCreationDate(LocalDate.now());
        userDto.setMail(userDto.getMail().toLowerCase());

        return userMapper.toUserDto(
                userRepository.save(userMapper.toUser(userDto)));
    }

    @Override
    public UserDto findById(Long id)  {
        return userMapper.toUserDto(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id)));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toUserDtoList(userRepository.findAll());
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthDate(userDto.getBirthDate());
        user.setMail(userDto.getMail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setRoles(userDto.getRoles());
        return userMapper.toUserDto(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);
    }

}

