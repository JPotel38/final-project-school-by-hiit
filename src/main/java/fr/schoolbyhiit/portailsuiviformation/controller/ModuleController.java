package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.dto.ModuleDto;
import fr.schoolbyhiit.portailsuiviformation.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/modules")
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService moduleService;

    @GetMapping("/{id}")
    public ModuleDto findById(@PathVariable Long id){
        return moduleService.findById(id);
    }

    @GetMapping
    public List<ModuleDto> getModules(){
        return moduleService.findAll();
    }

    @PostMapping
    public ModuleDto create(@RequestBody @Valid ModuleDto moduleDto){
        return moduleService.create(moduleDto);
    }

    @PutMapping("/{id}")
    public ModuleDto update(@PathVariable Long id, @RequestBody @Valid ModuleDto moduleDto){
        return moduleService.update(id,moduleDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){moduleService.delete(id);}
}
