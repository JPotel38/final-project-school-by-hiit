package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.FileRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.FileDto;
import fr.schoolbyhiit.portailsuiviformation.entity.File;
import fr.schoolbyhiit.portailsuiviformation.mapper.FileMapper;
import fr.schoolbyhiit.portailsuiviformation.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final FileMapper fileMapper;


    @Override
    public FileDto findById(Long id) {
        FileDto fileDto = fileMapper.toFileDto(fileRepository.findById(id).get());
        return fileDto;
    }

    @Override
    public FileDto create(FileDto fileDto) {

        File file = fileMapper.toFile(fileDto);
        return fileMapper.toFileDto(fileRepository.save(file));
    }

    @Override
    public List<FileDto> findAll() {
        return fileMapper.toFileDtoList(fileRepository.findAll());
    }

    @Override
    public FileDto update(Long id, FileDto fileDto) {

        File file = fileRepository.findById(id).get();
        file.setDesignation(fileDto.getDesignation());
        file.setCreationDate(fileDto.getCreationDate());
        return fileMapper.toFileDto(fileRepository.save(file));
    }

    @Override
    public void delete(Long id) {
        File file = fileRepository.findById(id).get();
        fileRepository.delete(file);

    }
}
