package com.berk.first.service.Impl;

import com.berk.first.helper.UserHelper;
import com.berk.first.mock.UserData;
import com.berk.first.model.Test;
import com.berk.first.model.User;
import com.berk.first.model.UserListResponse;
import com.berk.first.model.UserResponse;
import com.berk.first.repo.TestRepo;
import com.berk.first.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final UserData userData;
    final TestRepo testRepo;

    @Override
    public UserListResponse getAllUsers() {
        Test testBerk = new Test();
        testBerk.setTest("berk");
        testBerk.setIsActive("yes");

        testRepo.save(testBerk);
       // testRepo.findByTest("berk");
        return userData.getAll();
    }

    @Override
    public UserResponse getUserByUserId(String userId) {
        final UserResponse response = new UserResponse();
        List<Test> isActiveUsers = testRepo.findByIsActive("yes");

        final List<User> users = userData.getAll().getUsers();

        //burada stream filter için bir örnek bıraktım
        final User user = users.stream().filter(userItem -> userItem.getUserId().equals(userId)).findFirst().orElse(null);

        //lamda reference kullanımı ile ilgili bir örnek
        //uzun hali aşağıdaki gibi
        //users.forEach(item -> System.out.println(item));
        users.forEach(System.out::println);

        //her obje için uygulanmasını istediğimiz bir işlem var ise onu bu şekilde custom bir class ile de yapabiliriz sadece
        //System.out:prntln ile kullanılmıyor yani
        //burada bütün userları foreach ile gezip loglama yapacak
        users.forEach(UserHelper::logUsername);

        //yukarıdakinin uzun hali -> users.forEach(userItem -> UserHelper.logUsername(userItem));
        //temelde hepsinin en uzun hali aşağıdali gibi


        /*
        for (User userItemNew: users) {
            System.out.println(userItemNew.getUserId());
        }
         */
        response.setUser(user);

        return response;
    }
}
