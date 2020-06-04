# SM.MS API for Java

## 项目介绍

这是一个基于 Java 的 SM.MS 图床第三方工具库

SM.MS API 文档地址： https://doc.sm.ms/

## 使用

1. 下载项目后，在 `SmmsProperties` 类中配置 smms 的 API Token
2. 使用 `mvn install` 命令安装到本地 maven 仓库
3. 在 `pom.xml` 中引入：

```json
<dependency>
    <groupId>com.pupilcc</groupId>
    <artifactId>smms</artifactId>
    <version>0.0.1</version>
</dependency>
```

## TODO

- [x] 获取 API Token
- [x] 获取用户信息
- [x] 查看上传的历史记录
- [x] 上传图片
- [x] 删除图片
