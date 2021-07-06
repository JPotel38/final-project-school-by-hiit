package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.RoleRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.RoleDto;
import fr.schoolbyhiit.portailsuiviformation.mapper.RoleMapper;
import fr.schoolbyhiit.portailsuiviformation.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleDto> findAll() {
        return roleMapper.toRoleDtoList(
            roleRepository.findAll()
        );
    }
}
