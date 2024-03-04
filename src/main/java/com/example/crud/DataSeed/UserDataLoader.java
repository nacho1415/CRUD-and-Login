package com.example.crud.DataSeed;
import com.example.crud.Domain.User;
import com.example.crud.Repository.UserRepository;
import com.example.crud.Dto.UserDto.CreateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserDataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }
    private void loadUserData() {
//        if (userRepository.countUser() == 0) {
//            User user1 = userRepository.createUser(new CreateUserDto("dasd", "asd", "dasd"));
//            userRepository.save(user1);
//            User user2 = userRepository.createUser(new CreateUserDto("dasd", "asd", "dasd"));
//            userRepository.save(user2);
//            System.out.println(userRepository.countUser());
//        }
    }
}