package com.pupilcc.smms.user;

import com.pupilcc.smms.user.dto.ProfileDTO;
import com.pupilcc.smms.user.dto.TokenDTO;
import com.pupilcc.smms.user.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTests {
    @Autowired
    private UserService userService;

    @Test
    void getToken() {
        TokenDTO dto = userService.getToken();
        Assertions.assertEquals(dto.getSuccess(), true);
    }

    @Test
    void getProfile() {
        ProfileDTO dto = userService.getProfile();
        Assertions.assertEquals(dto.getSuccess(), true);
    }
}
