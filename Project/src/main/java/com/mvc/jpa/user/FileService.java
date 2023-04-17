package com.mvc.jpa.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FileService {
    private FileRepository repo;

    public FileService(FileRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Long saveFile(FileDTO fileDto) {
        return repo.save(fileDto.toEntity()).getId();
    }

    @Transactional
    public FileDTO getFile(Long id) {
        File file = repo.findById(id).get();

        FileDTO fileDto = FileDTO.builder()
                .id(id)
                .origFilename(file.getOrigFilename())
                .filename(file.getFilename())
                .filePath(file.getFilePath())
                .build();
        return fileDto;
    }
}