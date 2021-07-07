package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.dto.FileDto;
import fr.schoolbyhiit.portailsuiviformation.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/files/")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public FileDto findById(@PathVariable Long id) {
        return fileService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FileDto> getFiles(){
        return fileService.findAll();
    }

    @GetMapping("course/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<FileDto> getFilesByCourseId(@PathVariable Long id) {
        return fileService.getFilesByCourseId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FileDto create(@RequestBody @Valid FileDto fileDto){
        return fileService.create(fileDto);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public FileDto update(@PathVariable Long id, @RequestBody @Valid FileDto fileDto){
        return fileService.update(id,fileDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        fileService.delete(id);
    }
}
