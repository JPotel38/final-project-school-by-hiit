package fr.schoolbyhiit.portailsuiviformation.mapper;

import fr.schoolbyhiit.portailsuiviformation.dto.ModuleDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Module;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModuleMapper {

    ModuleDto toModuleDto(Module module);

    Module toModule(ModuleDto moduleDto);

    List<ModuleDto> toModuleDtoList(List<Module> modules);


}
