package com.pupilcc.smms.service;

import com.pupilcc.smms.base.dto.BaseDTO;
import com.pupilcc.smms.base.dto.BaseListDataDTO;
import com.pupilcc.smms.image.dto.ImageDataDTO;
import com.pupilcc.smms.image.service.ImageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
class ImageServiceTests {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ImageService imageService;

    @Test
    void uploadHistory() {
        BaseListDataDTO<ImageDataDTO> dto = imageService.uploadHistory();
        logger.info(dto.toString());
        Assertions.assertEquals(dto.getSuccess(), true);
    }

    @Test
    @Disabled
    void uploadImage() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://img.iplaysoft.com/wp-content/uploads/2019/free-images/free_stock_photo.jpg";
        ResponseEntity<Resource> entity = restTemplate.getForEntity(url, Resource.class);
        InputStream in = Objects.requireNonNull(entity.getBody()).getInputStream();
        MultipartFile multipartFile = new MockMultipartFile(
                "file.jpg", "free_stock_photo.jpg", "", in);

        BaseListDataDTO<ImageDataDTO> dto = imageService.uploadImage(multipartFile, "json");
        logger.info(dto.toString());
        Assertions.assertEquals(dto.getSuccess(), true);
    }

    @Test
    @Disabled
    void deleteImage() {
        BaseDTO dto = imageService.deleteImage("GrH1oPac7EmbWlFxvg4Uksd2QJ", "json");
        logger.info(dto.toString());
        Assertions.assertEquals(dto.getSuccess(), true);
    }
}
