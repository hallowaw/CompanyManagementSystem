package site.yanbin.controller;

import site.yanbin.response.Result;
import site.yanbin.util.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload2")
    public String upload2(String username, String age, MultipartFile image) throws Exception {
        log.info("接收到了参数：" + username + "---" + age + "----" + image);
        // 保存到本地磁盘：
        // 1、获取文件的原始名称，以便获取后缀
        String originalFilename = image.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")); // .png .txt
        // 2、随机一个文件名称
        String fileName = UUID.randomUUID() + suffix;

        // 3、存储到磁盘
        image.transferTo(new File("E:\\上海校区JavaWeb课程\\day11-SpringBootWeb案例\\代码\\images", fileName));

        return "success";
    }

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception {
        log.info("接收到了参数：" + image);
        // 把图片存储到 阿里云oss服务器上面去
        // 返回这个图片的地址，给前端去添加员工。
        String imageUrl = aliOSSUtils.upload(image);
        return Result.success(imageUrl);
    }
}
