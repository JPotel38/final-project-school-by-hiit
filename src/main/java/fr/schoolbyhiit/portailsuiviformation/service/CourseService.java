package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.dto.CourseDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Module;

import java.util.List;

public interface CourseService {

    CourseDto findById(Long id);

    CourseDto create(CourseDto courseDto);

    List<CourseDto> findAll();

    CourseDto update(Long id, CourseDto courseDto);

    void delete(Long id);

    List<CourseDto> getCoursesByModuleId(Long id);

    List<CourseDto> getCoursesByModule(Module module);
}
