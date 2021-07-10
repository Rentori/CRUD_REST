package service.impl;

import model.File;
import service.FileService;
import repository.hibernateImpl.FileRepositoryImpl;

import java.util.List;

public class FileServiceImpl implements FileService {
    private FileRepositoryImpl fileRepository = FileRepositoryImpl.getInstance();

    @Override
    public File save(File type) {
        return fileRepository.save(type);
    }

    @Override
    public File update(File type) {
        return fileRepository.update(type);
    }

    @Override
    public File getById(Long aLong) {
        return fileRepository.getById(aLong);
    }

    @Override
    public void deleteById(Long aLong) {
        fileRepository.deleteById(aLong);
    }

    @Override
    public List<File> getAll() {
        return fileRepository.getAll();
    }

    @Override
    public void setFileRepository(FileRepositoryImpl fileRepository) {
        this.fileRepository = fileRepository;
    }
}
