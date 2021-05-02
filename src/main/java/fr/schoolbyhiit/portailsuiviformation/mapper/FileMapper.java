package fr.schoolbyhiit.portailsuiviformation.mapper;

import fr.schoolbyhiit.portailsuiviformation.dto.FileDto;
import fr.schoolbyhiit.portailsuiviformation.dto.ModuleDto;
import fr.schoolbyhiit.portailsuiviformation.entity.File;
import fr.schoolbyhiit.portailsuiviformation.entity.Module;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FileMapper {

    FileDto toFileDto(File file);

    File toFile(FileDto fileDto);

    List<FileDto> toFileDtoList(List<File> files);
}
