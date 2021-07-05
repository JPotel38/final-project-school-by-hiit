package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.dto.ModuleDto;

import java.util.List;

public interface ModuleService {

    ModuleDto findById(Long id);

    ModuleDto create(ModuleDto moduleDto);

    List<ModuleDto> findAll();

    ModuleDto update(Long id, ModuleDto moduleDto);

    void delete(Long id);
}
