package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.UserRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.UserDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Role;
import fr.schoolbyhiit.portailsuiviformation.entity.User;
import fr.schoolbyhiit.portailsuiviformation.exception.EmailExistsException;
import fr.schoolbyhiit.portailsuiviformation.exception.UserNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.mapper.UserMapperImpl;
import fr.schoolbyhiit.portailsuiviformation.model.RoleName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapperImpl userMapper;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    void create() {
        //GIVEN
        User user = initUser();
        UserDto userDto = UserDto.builder()
                .id(1L).firstName(FIRSTNAME).lastName(LASTNAME)
                .birthDate(BIRTH_DATE)
                .mail(MAIL).password(PASSWORD).phoneNumber(PHONE_NUMBER)
                .roles(Set.of(Role.builder().name(RoleName.ADMIN).build()))
                .build();
        when(userMapper.toUserDto(any(User.class))).thenCallRealMethod();
        when(userMapper.toUser(any(UserDto.class))).thenCallRealMethod();
        when(userRepository.getUserByMail(anyString())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(user);
        //WHEN
        UserDto actual = userService.create(userDto);
        //THEN
        verify(userRepository, times(1)).save(any(User.class));
        verify(userMapper, times(1)).toUserDto(any(User.class));
        verify(userMapper, times(1)).toUser(any(UserDto.class));
        assertThat(actual.getCreationDate()).isNotNull();
    }

    @Test
    void create_should_throw_EmailExistsException() {
        //GIVEN
        User user = initUser();
        UserDto userDto = UserDto.builder()
                .id(1L).firstName(FIRSTNAME).lastName(LASTNAME)
                .birthDate(BIRTH_DATE)
                .mail(MAIL).password(PASSWORD).phoneNumber(PHONE_NUMBER)
                .roles(Set.of(Role.builder().name(RoleName.ADMIN).build()))
                .build();
        when(userRepository.getUserByMail(anyString())).thenReturn(Optional.of(user));
        //WHEN //THEN
        assertThatThrownBy(() -> userService.create(userDto))
                .isInstanceOf(EmailExistsException.class)
                .hasFieldOrPropertyWithValue("reason", "User with mail : " + userDto.getMail() + " already exist !");

    }

    @Test
    void findById() {
        //GIVEN
        UserDto userDto = initUserDto();
        User user = initUser();
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userMapper.toUserDto(any(User.class))).thenCallRealMethod();
        //WHEN
        UserDto actual = userService.findById(1L);
        //THEN
        assertThat(actual).usingRecursiveComparison().isEqualTo(userDto);
    }

    @Test
    void findById_should_throw_UserNotFoundException() {
        //GIVEN
        Long userId = 1L;
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        //WHEN THEN
        assertThatThrownBy(() -> userService.findById(userId))
                .isInstanceOf(UserNotFoundException.class)
                .hasFieldOrPropertyWithValue("reason", "User with id : " + userId + " not found !");

    }

    @Test
    void findAll() {
        //GIVEN
        List<User> users = initSomeUsers();
        List<UserDto> userDtoList = initSomeUserDtoList();
        when(userRepository.findAll()).thenReturn(users);
        when(userMapper.toUserDtoList(anyList())).thenReturn(userDtoList);
        //WHEN
        List<UserDto> actual = userService.findAll();
        //THEN
        assertThat(actual)
                .isNotNull()
                .isNotEmpty()
                .hasSameSizeAs(users);
        assertThat(actual.get(1))
                .usingRecursiveComparison()
                .isEqualTo(users.get(1));

    }

    @Test
    void update() {
        //GIVEN
        Long userId = 1L;
        User user = initUser();
        when(userMapper.toUserDto(any(User.class))).thenCallRealMethod();
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);
        UserDto updatedUser = UserDto.builder()
                .id(1L).firstName("new firstname").lastName("new lastname")
                .birthDate(BIRTH_DATE)
                .mail(MAIL).phoneNumber(PHONE_NUMBER)
                .build();
        //WHEN
        UserDto actual = userService.update(userId, updatedUser);
        //THEN
        assertThat(actual)
                .hasFieldOrPropertyWithValue("firstName", "new firstname")
                .hasFieldOrPropertyWithValue("lastName", "new lastname");
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void update_should_throw_UserNotFoundException() {
        //GIVEN
        Long userId = 1L;
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        UserDto updatedUser = UserDto.builder()
                .id(1L).firstName("new firstname").lastName("new lastname")
                .birthDate(BIRTH_DATE)
                .mail(MAIL).phoneNumber(PHONE_NUMBER)
                .build();
        //WHEN //THEN
        assertThatThrownBy(() -> userService.update(userId, updatedUser))
                .isInstanceOf(UserNotFoundException.class)
                .hasFieldOrPropertyWithValue("reason", "User with id : " + userId + " not found !");
    }

    @Test
    void delete() {
        //GIVEN

        //WHEN

        //THEN

    }

    @Test
    void delete_should_throw_UserNotFoundException() {
        //GIVEN
        Long userId = 1L;
        //WHEN //THEN
        assertThatThrownBy(() -> userService.delete(userId))
                .isInstanceOf(UserNotFoundException.class)
                .hasFieldOrPropertyWithValue("reason", "User with id : " + userId + " not found !");
    }


    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String MAIL = "";
    private static final String PASSWORD = "pwd";
    private static final String PHONE_NUMBER = "00000000";
    private static final LocalDate BIRTH_DATE = LocalDate.of(2001, 1, 1);


    private User initUser() {
        return User.builder()
                .id(1L).firstName(FIRSTNAME).lastName(LASTNAME)
                .birthDate(BIRTH_DATE).creationDate(LocalDate.now())
                .mail(MAIL).password(PASSWORD).phoneNumber(PHONE_NUMBER)
                .roles(Set.of(Role.builder().name(RoleName.ADMIN).build()))
                .build();
    }

    private UserDto initUserDto() {
        return UserDto.builder()
                .id(1L).firstName(FIRSTNAME).lastName(LASTNAME)
                .birthDate(BIRTH_DATE).creationDate(LocalDate.now())
                .mail(MAIL).password(PASSWORD).phoneNumber(PHONE_NUMBER)
                .roles(Set.of(Role.builder().name(RoleName.ADMIN).build()))
                .build();
    }

    private List<User> initSomeUsers() {
        return List.of(
                User.builder()
                        .id(1L).firstName(FIRSTNAME).lastName(LASTNAME)
                        .birthDate(BIRTH_DATE).creationDate(LocalDate.now())
                        .mail(MAIL).password(PASSWORD).phoneNumber(PHONE_NUMBER)
                        .roles(Set.of(Role.builder().name(RoleName.ADMIN).build()))
                        .build(),
                User.builder()
                        .id(2L).firstName(FIRSTNAME).lastName(LASTNAME)
                        .birthDate(BIRTH_DATE).creationDate(LocalDate.now())
                        .mail(MAIL).password(PASSWORD).phoneNumber(PHONE_NUMBER)
                        .roles(Set.of(Role.builder().name(RoleName.ADMIN).build()))
                        .build());
    }

    private List<UserDto> initSomeUserDtoList() {
        return List.of(
                UserDto.builder()
                        .id(1L).firstName(FIRSTNAME).lastName(LASTNAME)
                        .birthDate(BIRTH_DATE).creationDate(LocalDate.now())
                        .mail(MAIL).password(PASSWORD).phoneNumber(PHONE_NUMBER)
                        .roles(Set.of(Role.builder().name(RoleName.ADMIN).build()))
                        .build(),
                UserDto.builder()
                        .id(2L).firstName(FIRSTNAME).lastName(LASTNAME)
                        .birthDate(BIRTH_DATE).creationDate(LocalDate.now())
                        .mail(MAIL).password(PASSWORD).phoneNumber(PHONE_NUMBER)
                        .roles(Set.of(Role.builder().name(RoleName.ADMIN).build()))
                        .build());
    }
}
