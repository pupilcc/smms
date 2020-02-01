package com.pupilcc.smms.user;

import com.pupilcc.smms.base.dto.BaseDataDTO;
import com.pupilcc.smms.user.dto.ProfileDataDTO;
import com.pupilcc.smms.user.dto.TokenDataDTO;
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
        BaseDataDTO<TokenDataDTO> dto = userService.getToken();
        Assertions.assertEquals(dto.getSuccess(), true);
    }

    @Test
    void getProfile() {
        BaseDataDTO<ProfileDataDTO> dto = userService.getProfile();
        Assertions.assertEquals(dto.getSuccess(), true);
    }
}
