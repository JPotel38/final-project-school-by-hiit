package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.dto.CourseDto;
import fr.schoolbyhiit.portailsuiviformation.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/courses/")
public class CourseController {

    private  final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseDto findById(@PathVariable Long id){
        return courseService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDto> getCourses(){
        return courseService.findAll();
    }

    @GetMapping("module/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDto> getCoursesByModuleId(@PathVariable Long id){
        return courseService.getCoursesByModuleId(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto create(@RequestBody @Valid CourseDto courseDto){
        return courseService.create(courseDto);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseDto update(@PathVariable Long id, @RequestBody @Valid CourseDto courseDto){
        return courseService.update(id,courseDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        courseService.delete(id);
    }


}
