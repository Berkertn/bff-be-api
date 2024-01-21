package com.berk.first.mock;

import com.berk.first.model.User;
import com.berk.first.model.UserListResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserData {

    private final ObjectMapper objectMapper;

    public UserListResponse getAll() {
        //Database olmadığı için manuel buraya data ekledim

        final UserListResponse users;
        try {
            //Object mapper ile bir json dosyasından java objesine data nasıl atılabilir bunu da gstermek için burada mock dataları
            //buradan okuduk
            users = objectMapper.readValue(new File("src/main/resources/mock/users.json"),
                    UserListResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

}
