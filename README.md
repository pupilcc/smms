# SM.MS API for Java

## 项目介绍

封装了 sm.ms 图床 API 的 Java 工具库 (已发布 maven 中央仓库)

SM.MS API 文档地址： https://doc.sm.ms/

## 使用

1. 在 `pom.xml` 中引入:

```xml
<dependency>
    <groupId>com.pupilcc.sdk</groupId>
    <artifactId>smms</artifactId>
    <version>0.0.3</version>
</dependency>
```

2. 在 `application.yml` 配置中添加 token
```yml
smms:
  token: xxxxxxx
```

3. 在类中引入 `SmmsService`
```java
@Slf4j
@SpringBootTest
class SmmsServiceTests {

    @Autowired
    private SmmsService smmsService;

    @Test
    void getProfile() {
        BaseDataResponse<ProfileDataDTO> dto = smmsService.getProfile();
        log.info("用户信息:" + dto.getData());
        Assertions.assertEquals(dto.getSuccess(), true);
    }
}
```

## TODO

- [x] 获取用户信息
- [x] 查看上传的历史记录
- [x] 上传图片
- [x] 删除图片
