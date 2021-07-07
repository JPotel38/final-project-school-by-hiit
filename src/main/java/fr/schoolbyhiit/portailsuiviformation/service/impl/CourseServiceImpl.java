package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.CourseRepository;
import fr.schoolbyhiit.portailsuiviformation.dao.ModuleRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.CourseDto;
import fr.schoolbyhiit.portailsuiviformation.dto.FileDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Course;
import fr.schoolbyhiit.portailsuiviformation.entity.Module;
import fr.schoolbyhiit.portailsuiviformation.exception.BadFormatException;
import fr.schoolbyhiit.portailsuiviformation.exception.CourseNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.exception.ModuleNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.mapper.CourseMapper;
import fr.schoolbyhiit.portailsuiviformation.service.CourseService;
import fr.schoolbyhiit.portailsuiviformation.service.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final FileService fileService;
    private final ModuleRepository moduleRepository;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper, FileService fileService, ModuleRepository moduleRepository) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.fileService = fileService;
        this.moduleRepository = moduleRepository;
    }

    @Override
    public CourseDto findById(Long id) {
      return courseMapper.toCourseDto(courseRepository.findById(id)
          .orElseThrow(()->new CourseNotFoundException(id)));
    }

    @Override
    public CourseDto create(CourseDto courseDto) {
        validCourseData(courseDto);
        courseDto.setDesignation(courseDto.getDesignation());
        courseDto.setDate(LocalDate.now());
        courseDto.setStartTime(LocalTime.now());
        courseDto.setEndTime(LocalTime.now());
        courseDto.setModule(courseDto.getModule());
        return courseMapper.toCourseDto(courseRepository.save(courseMapper.toCourse(courseDto)));
    }

    @Override
    public List<CourseDto> findAll() {
        return courseMapper.toCourseDtoList(courseRepository.findAll());
    }

    @Override
    public CourseDto update(Long id, CourseDto courseDto) {
        validCourseData(courseDto);
        Course course = courseRepository.findById(id).orElseThrow(()->new CourseNotFoundException(id));
        course.setDesignation(courseDto.getDesignation());
        course.setDate(courseDto.getDate());
        course.setStartTime(courseDto.getStartTime());
        course.setEndTime(courseDto.getEndTime());
        return courseMapper.toCourseDto(courseRepository.save(course));
    }

    @Override
    public void delete(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(()->new CourseNotFoundException(id));
        deleteFileByCourseId(id);
        courseRepository.delete(course);
    }

    @Override
    public List<CourseDto> getCoursesByModuleId(Long id) {
        Module module = moduleRepository.findById(id).orElseThrow(() -> new ModuleNotFoundException(id));
        return courseMapper.toCourseDtoList(courseRepository.getCoursesByModule(module));
    }


    private void validCourseData(CourseDto courseDto) {
        if (courseDto == null
            || StringUtils.isBlank(courseDto.getDesignation())
            || courseDto.getDate() == null
            || courseDto.getStartTime() == null
            || courseDto.getEndTime() == null
            ||courseDto.getModule() == null){
            throw new BadFormatException(" Tous les champs sont obligatoires");
        }
    }

    @Override
    public List<CourseDto> getCoursesByModule(Module module){
        return courseMapper.toCourseDtoList(courseRepository.getCoursesByModule(module));
    }

    private void deleteFileByCourseId(Long id){
        List<FileDto> fileList = fileService.getFilesByCourse(courseMapper.toCourse(findById(id)));
        fileList
            .forEach((file)-> fileService.delete(file.getId()));
    }
}
