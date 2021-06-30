package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.CourseRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.CourseDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Course;
import fr.schoolbyhiit.portailsuiviformation.entity.Module;
import fr.schoolbyhiit.portailsuiviformation.exception.CourseNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.mapper.CourseMapper;
import fr.schoolbyhiit.portailsuiviformation.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseDto findById(Long id) {
        final Course course = courseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
        return courseMapper.toCourseDto(course);
    }

    @Override
    public CourseDto create(CourseDto courseDto) {
        Course course = courseMapper.toCourse(courseDto);
        return courseMapper.toCourseDto(courseRepository.save(course));
    }

    @Override
    public List<CourseDto> findAll() {
        return courseMapper.toCourseDtoList(courseRepository.findAll());
    }

    @Override
    public CourseDto update(Long id, CourseDto courseDto) {

        Course course = courseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
        course.setDesignation(courseDto.getDesignation());
        course.setDate(courseDto.getDate());
        course.setStartTime(courseDto.getStartTime());
        course.setEndTime(courseDto.getEndTime());
        course.setFiles(courseDto.getFiles());

        return courseMapper.toCourseDto(courseRepository.save(course));
    }

    @Override
    public void delete(Long id) {
        courseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
        courseRepository.deleteById(id);

    }
    @Override
    public List<CourseDto> getCoursesbyModule(Module module){
        return courseMapper.toCourseDtoList(courseRepository.getCoursesByModule(module));
    }
}
