package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.CourseRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.CourseDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Course;
import fr.schoolbyhiit.portailsuiviformation.mapper.CourseMapper;
import fr.schoolbyhiit.portailsuiviformation.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseDto findById(Long id) {
        CourseDto courseDto = courseMapper.toCourseDto(courseRepository.findById(id).get());
        return courseDto;
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

        Course course = courseRepository.findById(id).get();
        course.setDesignation(courseDto.getDesignation());
        course.setDate(courseDto.getDate());
        course.setFiles(courseDto.getFiles());

        return courseMapper.toCourseDto(courseRepository.save(course));
    }

    @Override
    public void delete(Long id) {
        Course course =courseRepository.findById(id).get();
        courseRepository.delete(course);

    }
}
