package com.pupilcc.smms.user;

import com.pupilcc.smms.image.dto.UploadHistoryDTO;
import com.pupilcc.smms.image.dto.UploadImageDTO;
import com.pupilcc.smms.image.service.ImageService;
import org.junit.jupiter.api.Assertions;
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
class ImageServiceTests {
    @Autowired
    private ImageService imageService;

    @Test
    void uploadHistory() {
        UploadHistoryDTO dto = imageService.uploadHistory();
        Assertions.assertEquals(dto.getSuccess(), true);
    }

    @Test
    void uploadImage() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://img.iplaysoft.com/wp-content/uploads/2019/free-images/free_stock_photo.jpg";
        ResponseEntity<Resource> entity = restTemplate.getForEntity(url, Resource.class);
        InputStream in = Objects.requireNonNull(entity.getBody()).getInputStream();
        MultipartFile multipartFile = new MockMultipartFile(
                "file.jpg", "free_stock_photo.jpg", "", in);

        UploadImageDTO dto = imageService.uploadImage(multipartFile, "json");
        Assertions.assertEquals(dto.getSuccess(), true);
    }
}
