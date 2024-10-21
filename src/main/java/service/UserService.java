package service;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long addUser(String name) {
        Long id = userRepository.addAndReturnId(name);
        log.info(String.format("Create user id=[%s]", id));
        return id;
    }

    public User getById(Long id) {
        User user = userRepository.getById(id);
        log.info(String.format("Get user [ %s ]", user));
        return user;
    }

    public void deleteById(Long userId) {
        userExsistsCheck(userId);
        userRepository.deleteById(userId);
        log.info("Delete user id = " + userId);
    }

    public void userExsistsCheck(Long userId) {
        if (!userRepository.userExists(userId)) {
            log.info(String.format("User with id[%s] doesn`t exist", userId));
            throw new RuntimeException(String.format("User with id[%s] doesn`t exist", userId));
        }
    }
}