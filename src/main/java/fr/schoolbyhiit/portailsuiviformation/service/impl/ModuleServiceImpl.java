package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.ModuleRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.CourseDto;
import fr.schoolbyhiit.portailsuiviformation.dto.ModuleDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Module;
import fr.schoolbyhiit.portailsuiviformation.exception.BadFormatException;
import fr.schoolbyhiit.portailsuiviformation.exception.ModuleNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.mapper.ModuleMapper;
import fr.schoolbyhiit.portailsuiviformation.service.CourseService;
import fr.schoolbyhiit.portailsuiviformation.service.ModuleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;
    private final ModuleMapper moduleMapper;
    private final CourseService courseService;

    public ModuleServiceImpl(ModuleRepository moduleRepository, ModuleMapper moduleMapper, CourseService courseService) {
        this.moduleRepository = moduleRepository;
        this.moduleMapper = moduleMapper;
        this.courseService = courseService;
    }

    @Override
    public ModuleDto findById(Long id) {
        return moduleMapper.toModuleDto(moduleRepository.findById(id)
            .orElseThrow(()->new ModuleNotFoundException(id)));
    }

    @Override
    public ModuleDto create(ModuleDto moduleDto) {
        validModuleData(moduleDto);
        moduleDto.setDesignation(moduleDto.getDesignation());
        return moduleMapper.toModuleDto(moduleRepository.save(moduleMapper.toModule(moduleDto)));
    }


    @Override
    public List<ModuleDto> findAll() {
        return moduleMapper.toModuleDtoList(moduleRepository.findAll());
    }

    @Override
    public ModuleDto update(Long id, ModuleDto moduleDto) {
        validModuleData(moduleDto);
        Module module = moduleRepository.findById(id)
            .orElseThrow(()->new ModuleNotFoundException(id));
        module.setDesignation(moduleDto.getDesignation());
        return moduleMapper.toModuleDto(moduleRepository.save(module));
    }

    @Override
    public void delete(Long id) {
        Module module = moduleRepository.findById(id)
            .orElseThrow(()->new ModuleNotFoundException(id));
        deleteCourseByModuleId(id);
        moduleRepository.delete(module);

    }

    private void validModuleData(ModuleDto moduleDto) {
        if (moduleDto == null
            || StringUtils.isBlank(moduleDto.getDesignation())){
            throw new BadFormatException(" Tous les champs sont obligatoires");
        }
    }

    private void deleteCourseByModuleId(Long id){
        List<CourseDto> courseList = courseService.getCoursesByModule(moduleMapper.toModule(findById(id)));
        courseList
            .forEach((course)-> courseService.delete(course.getId()) );
    }
}
