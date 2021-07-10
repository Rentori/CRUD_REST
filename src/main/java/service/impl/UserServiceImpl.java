package service.impl;

import model.User;
import repository.hibernateImpl.UserRepositoryImpl;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();

    @Override
    public User save(User type) {
        return userRepository.save(type);
    }

    @Override
    public User update(User type) {
        return userRepository.update(type);
    }

    @Override
    public User getById(Long aLong) {
        return userRepository.getById(aLong);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void setUserRepository(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }
}
