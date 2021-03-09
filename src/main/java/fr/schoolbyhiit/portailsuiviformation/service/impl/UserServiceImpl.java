package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.controller.exception.UserNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.dao.UserRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.UserDto;
import fr.schoolbyhiit.portailsuiviformation.entity.User;
import fr.schoolbyhiit.portailsuiviformation.mapper.UserMapper;
import fr.schoolbyhiit.portailsuiviformation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;



    @Override
    public UserDto create(UserDto userDto) {
        userDto.setCreationDate(LocalDate.now());
        // TODO control inputs
        User user = userMapper.toUser(userDto);
        return userMapper.toUserDto(userRepository.save(user));
    }

    @Override
    public UserDto findById(Long id) {
        UserDto userDto = userMapper.toUserDto(userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.INSTANCE));
        return userDto;
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toUserDtoList(userRepository.findAll());
    }

    @Override
    public UserDto update(Long id, UserDto userDto){
        User user = userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.INSTANCE);

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
                .orElseThrow(() -> UserNotFoundException.INSTANCE);
        userRepository.delete(user);
    }
}
