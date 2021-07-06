package fr.schoolbyhiit.portailsuiviformation.mapper;

import fr.schoolbyhiit.portailsuiviformation.dto.RoleDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto toRoleDto(Role role);

    Set<RoleDto> toRoleDtoSet(Set<Role> role);

    List<RoleDto> toRoleDtoList(List<Role> role);
}
