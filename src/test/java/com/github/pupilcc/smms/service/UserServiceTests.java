package com.github.pupilcc.smms.service;

import com.github.pupilcc.smms.base.dto.BaseDataDTO;
import com.github.pupilcc.smms.user.dto.ProfileDataDTO;
import com.github.pupilcc.smms.user.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTests {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Test
    void getProfile() {
        BaseDataDTO<ProfileDataDTO> dto = userService.getProfile();
        logger.info("用户信息:" + dto.getData());
        Assertions.assertEquals(dto.getSuccess(), true);
    }
}
