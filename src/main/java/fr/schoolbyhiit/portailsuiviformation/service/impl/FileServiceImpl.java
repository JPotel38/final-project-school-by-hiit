package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.FileRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.CourseDto;
import fr.schoolbyhiit.portailsuiviformation.dto.FileDto;
import fr.schoolbyhiit.portailsuiviformation.dto.ModuleDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Course;
import fr.schoolbyhiit.portailsuiviformation.entity.File;
import fr.schoolbyhiit.portailsuiviformation.exception.BadFormatException;
import fr.schoolbyhiit.portailsuiviformation.exception.FileNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.mapper.FileMapper;
import fr.schoolbyhiit.portailsuiviformation.service.CourseService;
import fr.schoolbyhiit.portailsuiviformation.service.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final FileMapper fileMapper;


    public FileServiceImpl(FileRepository fileRepository, FileMapper fileMapper) {
        this.fileRepository = fileRepository;
        this.fileMapper = fileMapper;
    }

    @Override
    public FileDto findById(Long id) {
       return fileMapper.toFileDto(fileRepository.findById(id)
           .orElseThrow(()->new FileNotFoundException(id)));
    }

    @Override
    public FileDto create(FileDto fileDto) {
        validFileData(fileDto);
        fileDto.setDesignation(fileDto.getDesignation());
        fileDto.setCreationDate(LocalDateTime.now());
        fileDto.setLink(fileDto.getLink());
        fileDto.setCourse(fileDto.getCourse());
        return fileMapper.toFileDto(fileRepository.save(fileMapper.toFile(fileDto)));
    }

    @Override
    public List<FileDto> findAll() {
        return fileMapper.toFileDtoList(fileRepository.findAll());
    }

    @Override
    public FileDto update(Long id, FileDto fileDto) {

        validFileData(fileDto);
        File file = fileRepository.findById(id).orElseThrow(()->new FileNotFoundException(id));
        file.setDesignation(fileDto.getDesignation());
        file.setCreationDate(fileDto.getCreationDate());
        file.setLink(file.getLink());
        file.setCourse(file.getCourse());
        return fileMapper.toFileDto(fileRepository.save(file));
    }

    @Override
    public void delete(Long id) {
        fileRepository.deleteById(id);
//        File file = fileRepository.findById(id)
//            .orElseThrow(()->new FileNotFoundException(id));
//        fileRepository.delete(file);

    }

    @Override
    public List<FileDto> getFilesByCourse(Course course) {
        return fileMapper.toFileDtoList(fileRepository.getFilesByCourse(course));
    }

    private void validFileData(FileDto fileDto) {
        if (fileDto == null
            || StringUtils.isBlank(fileDto.getDesignation())
            || StringUtils.isBlank(fileDto.getLink())
            || fileDto.getCourse() == null){
            throw new BadFormatException(" Tous les champs sont obligatoires");
        }
    }
}
