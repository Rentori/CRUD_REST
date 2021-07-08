package service;

import model.File;
import repository.hibernateImpl.FileRepositoryImpl;

import java.util.List;

public class FileService implements GenericService<File, Long> {
    private final FileRepositoryImpl fileRepository = FileRepositoryImpl.getInstance();
    @Override
    public void setRepository(File type) {

    }

    @Override
    public File save(File type) {
        return null;
    }

    @Override
    public File update(File type) {
        return null;
    }

    @Override
    public File getById(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<File> getAll() {
        return fileRepository.getAll();
    }
}
