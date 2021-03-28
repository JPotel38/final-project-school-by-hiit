package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.ModuleRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.ModuleDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Module;
import fr.schoolbyhiit.portailsuiviformation.mapper.ModuleMapper;
import fr.schoolbyhiit.portailsuiviformation.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;
    private final ModuleMapper moduleMapper;

    @Override
    public ModuleDto findById(Long id) {
        ModuleDto moduleDto = moduleMapper.toModuleDto(moduleRepository.findById(id).get());
        return moduleDto;
    }

    @Override
    public ModuleDto create(ModuleDto moduleDto) {

        Module module = moduleMapper.toModule(moduleDto);
        return moduleMapper.toModuleDto(moduleRepository.save(module));
    }

    @Override
    public List<ModuleDto> findAll() {
        return moduleMapper.toModuleDtoList(moduleRepository.findAll());
    }

    @Override
    public ModuleDto update(Long id, ModuleDto moduleDto) {

        Module module = moduleRepository.findById(id).get();
        module.setDesignation(moduleDto.getDesignation());
        module.setCourses(moduleDto.getCourses());
        return moduleMapper.toModuleDto(moduleRepository.save(module));
    }

    @Override
    public void delete(Long id) {
        Module module = moduleRepository.findById(id).get();
        moduleRepository.delete(module);

    }
}
