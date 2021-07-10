package service;

import model.File;
import repository.hibernateImpl.FileRepositoryImpl;

public interface FileService extends GenericService<File, Long> {
    void setFileRepository(FileRepositoryImpl fileRepository);
}

