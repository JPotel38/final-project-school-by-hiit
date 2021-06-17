package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.ModuleRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.ModuleDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Module;
import fr.schoolbyhiit.portailsuiviformation.exception.BadFormatException;
import fr.schoolbyhiit.portailsuiviformation.exception.ModuleNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.mapper.ModuleMapper;
import fr.schoolbyhiit.portailsuiviformation.service.ModuleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;
    private final ModuleMapper moduleMapper;

    public ModuleServiceImpl(ModuleRepository moduleRepository, ModuleMapper moduleMapper) {
        this.moduleRepository = moduleRepository;
        this.moduleMapper = moduleMapper;
    }

    @Override
    public ModuleDto findById(Long id) {
        final Module module = moduleRepository.findById(id).orElseThrow(ModuleNotFoundException::new);
        return moduleMapper.toModuleDto(module);
    }

    @Override
    public ModuleDto create(ModuleDto moduleDto) {
        validModuleData(moduleDto);
        Module module = moduleMapper.toModule(moduleDto);
        return moduleMapper.toModuleDto(moduleRepository.save(module));
    }


    @Override
    public List<ModuleDto> findAll() {
        return moduleMapper.toModuleDtoList(moduleRepository.findAll());
    }

    @Override
    public ModuleDto update(Long id, ModuleDto moduleDto) {

        validModuleData(moduleDto);
        Module module = moduleRepository.findById(id).orElseThrow(ModuleNotFoundException::new);
        module.setDesignation(moduleDto.getDesignation());
        module.setCourses(moduleDto.getCourses());
        return moduleMapper.toModuleDto(moduleRepository.save(module));
    }

    @Override
    public void delete(Long id) {
        moduleRepository.findById(id).orElseThrow(ModuleNotFoundException::new);
        moduleRepository.deleteById(id);

    }

    private void validModuleData(ModuleDto moduleDto) {
        if (moduleDto == null || StringUtils.isBlank(moduleDto.getDesignation())
            || moduleDto.getCourses() == null || moduleDto.getCourses().isEmpty()) {
            throw new BadFormatException(" Tous les champs sont obligatoires");
        }
    }
}
