package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.dto.FileDto;

import java.util.List;

public interface FileService {

    FileDto findById(Long id);

    FileDto create(FileDto fileDto);

    List<FileDto> findAll();

    FileDto update(Long id, FileDto fileDto);

    void delete(Long id);
}
