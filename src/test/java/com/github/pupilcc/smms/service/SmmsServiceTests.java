package com.github.pupilcc.smms.service;

import com.github.pupilcc.smms.domain.SmmsService;
import com.github.pupilcc.smms.dto.ImageDataDTO;
import com.github.pupilcc.smms.dto.ProfileDataDTO;
import com.github.pupilcc.smms.response.BaseDataResponse;
import com.github.pupilcc.smms.response.BaseListDataResponse;
import com.github.pupilcc.smms.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Objects;

@SpringBootTest
@Slf4j
class SmmsServiceTests {

    @Autowired
    private SmmsService smmsService;

    @Test
    void getProfile() {
        BaseDataResponse<ProfileDataDTO> dto = smmsService.getProfile();
        log.info("用户信息:" + dto.getData());
        Assertions.assertEquals(dto.getSuccess(), true);
    }

    @Test
    @Disabled
    void uploadHistory() {
        BaseListDataResponse<ImageDataDTO> dto = smmsService.uploadHistory();
        log.info(dto.toString());
        Assertions.assertEquals(dto.getSuccess(), true);
    }

    @Test
    @Disabled
    void uploadImage() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://vip2.loli.io/2022/07/03/U3h1ODWtNS2YClq.jpg";
        ResponseEntity<Resource> entity = restTemplate.getForEntity(url, Resource.class);
        InputStream in = Objects.requireNonNull(entity.getBody()).getInputStream();
        MultipartFile multipartFile = new MockMultipartFile(
                "file.jpg", "U3h1ODWtNS2YClq.jpg", "", in);

        BaseDataResponse<ImageDataDTO> dto = smmsService.uploadImage(multipartFile, "json");
        log.info(dto.toString());
        Assertions.assertEquals(dto.getSuccess(), true);
    }

    @Test
    @Disabled
    void deleteImage() {
        BaseResponse dto = smmsService.deleteImage("MuQsRlE6qBpWb8NKFHIgxnfSdm", "json");
        log.info(dto.toString());
        Assertions.assertEquals(dto.getSuccess(), true);
    }
}
