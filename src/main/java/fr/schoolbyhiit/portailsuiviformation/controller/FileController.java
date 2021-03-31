package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.dto.FileDto;
import fr.schoolbyhiit.portailsuiviformation.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping("/{id}")
    public FileDto findById(@PathVariable Long id) {
        return fileService.findById(id);
    }

    @GetMapping
    public List<FileDto> getFiles(){
        return fileService.findAll();
    }

    @PostMapping
    public FileDto create(@RequestBody @Valid FileDto fileDto){
        return fileService.create(fileDto);
    }

    @PutMapping("/{id}")
    public FileDto update(@PathVariable Long id, @RequestBody @Valid FileDto fileDto){
        return fileService.update(id,fileDto);
    }

    @DeleteMapping("{/id}")
    public void delete(@PathVariable Long id){
        fileService.delete(id);
    }
}
