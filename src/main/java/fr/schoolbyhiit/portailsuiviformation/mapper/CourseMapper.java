package fr.schoolbyhiit.portailsuiviformation.mapper;

import fr.schoolbyhiit.portailsuiviformation.dto.CourseDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDto toCourseDto(Course course);

    Course toCourse(CourseDto courseDto);

    List<CourseDto> toCourseDtoList(List<Course> courses);
}
