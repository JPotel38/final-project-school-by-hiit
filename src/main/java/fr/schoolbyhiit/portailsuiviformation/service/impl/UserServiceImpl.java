package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.RoleRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.RoleDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Role;
import fr.schoolbyhiit.portailsuiviformation.exception.EmailExistsException;
import fr.schoolbyhiit.portailsuiviformation.exception.InvalidRoleException;
import fr.schoolbyhiit.portailsuiviformation.exception.UserNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.dao.UserRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.UserDto;
import fr.schoolbyhiit.portailsuiviformation.entity.User;
import fr.schoolbyhiit.portailsuiviformation.mapper.UserMapper;
import fr.schoolbyhiit.portailsuiviformation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

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

        User user = userMapper.toUser(userDto);
        user.setRoles(retrieveUserRoles(userDto));

        return userMapper.toUserDto(userRepository.save(user));
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

        user.setMail(userDto.getMail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(userDto.getPassword());
        user.setRoles(retrieveUserRoles(userDto));
        return userMapper.toUserDto(userRepository.save(user));
    }

    @Override
    public Boolean delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);
        return true;
    }

    private Set<Role> retrieveUserRoles(UserDto userDto){
        return userDto.getRoles()
            .stream()
            .map(RoleDto::getName)
            .map(roleName -> roleRepository.findByName(roleName)
                .orElseThrow(() -> InvalidRoleException.INSTANCE))
            .collect(Collectors.toSet());
    }

}

