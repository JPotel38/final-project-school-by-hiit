package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.dto.ModuleDto;
import fr.schoolbyhiit.portailsuiviformation.service.ModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ModuleDto findById(@PathVariable Long id){
        return moduleService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ModuleDto> getModules(){
        return moduleService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ModuleDto create(@RequestBody @Valid ModuleDto moduleDto){
        return moduleService.create(moduleDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ModuleDto update(@PathVariable Long id, @RequestBody @Valid ModuleDto moduleDto){
        return moduleService.update(id,moduleDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){moduleService.delete(id);}
}
