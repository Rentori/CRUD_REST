package service;

import model.User;
import repository.hibernateImpl.UserRepositoryImpl;

public interface UserService extends GenericService<User, Long> {
    void setUserRepository(UserRepositoryImpl userRepository);
}
