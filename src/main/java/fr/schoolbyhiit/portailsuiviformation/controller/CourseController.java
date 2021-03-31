package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.dto.CourseDto;
import fr.schoolbyhiit.portailsuiviformation.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private  final CourseService courseService;

    @GetMapping("/{id}")
    public CourseDto findById(@PathVariable Long id){
        return courseService.findById(id);
    }

    @GetMapping
    public List<CourseDto> getCourses(){
        return courseService.findAll();
    }

    @PostMapping
    public CourseDto create(@RequestBody @Valid CourseDto courseDto){
        return courseService.create(courseDto);
    }

    @PutMapping("/{id}")
    public CourseDto update(@PathVariable Long id, @RequestBody @Valid CourseDto courseDto){
        return courseService.update(id,courseDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        courseService.delete(id);
    }


}
