package com.berk.first.service.Impl;

import com.berk.first.entities.UserDataBase;
import com.berk.first.helper.UserHelper;
import com.berk.first.mock.UserData;
import com.berk.first.model.*;
import com.berk.first.dao.requests.UserCreateRequest;
import com.berk.first.dao.requests.UserDeleteRequest;
import com.berk.first.dao.response.ErrorResponse;
import com.berk.first.dao.response.Response;
import com.berk.first.dao.response.UserListResponse;
import com.berk.first.dao.response.UserResponse;
import com.berk.first.repo.UserRepository;
import com.berk.first.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.berk.first.helper.UserHelper.logError;
import static com.berk.first.helper.UserHelper.logInfo;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final UserData userData;
    final UserRepository userRepository;

    @Override
    public UserListResponse getAllUsers() {
        return userData.getAll();
    }

    @Override
    public UserResponse getUserByUserId(String userId) {
        final UserResponse response = new UserResponse();
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

    @Override
    public UserResponse setUserWithData(UserCreateRequest request) {
        final UserResponse response = new UserResponse();
        UserDataBase dbData = new UserDataBase();
        logInfo(String.format("email: %s, name: %s, surname: %s", request.getEmail(), request.getName(), request.getSurname()));
        dbData.setEmail(request.getEmail());
        dbData.setSurname(request.getName());
        dbData.setName(request.getSurname());
        UserDataBase userDbCred;

        try {
            userDbCred = userRepository.save(dbData);
            if (userDbCred != null) {
                logInfo("User added in db with cred");
                User savedUserInfo = new User();
                savedUserInfo.setUserId(String.valueOf(userDbCred.getRowId()));
                savedUserInfo.setName(userDbCred.getName());
                savedUserInfo.setSurname(userDbCred.getSurname());
                savedUserInfo.setEmail(userDbCred.getEmail());
                response.setUser(savedUserInfo);
            } else {
                logError("User can not added in db");
            }
        } catch (Exception e) {
            logError("An error occurred during user save:", e);
        }
        return response;
    }

    @Override
    public Response deleteUserWithData(UserDeleteRequest request) {
        UUID userIdFromRequest = request.getUserId();
        final Response response = new Response();

        if (userRepository.existsById(userIdFromRequest)) {
            List<UserDataBase> foundUsers = userRepository.findByRowId(userIdFromRequest);
            logInfo(foundUsers.get(0).toString());
            try {
                userRepository.deleteById(userIdFromRequest);
                response.setSuccess(true);
                response.setData(foundUsers.get(0));

            } catch (Exception e) {
                response.setSuccess(false);
                response.setData(userIdFromRequest);
            }
        } else {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.getErrorList().add(String.format("Searching User can not find: %s ", userIdFromRequest));
            response.setSuccess(false);
            response.setData(errorResponse);
        }
        return response;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
