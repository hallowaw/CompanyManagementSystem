package site.yanbin.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Data
@Component // 让当前工具类成为spring框架被管理的对象。
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSUtils {
//    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

//    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

//    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

//    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    public String upload(MultipartFile image) throws Exception {
        // 获取图片的后缀，使用一个随机的名称。
        String originalFilename = image.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID() + suffix;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            // 读取文件的字节输入流，把image对象转换成字节输入流
            InputStream is = image.getInputStream();
            // 开始发送文件到阿里云oss服务器
            ossClient.putObject(bucketName, fileName, is);

            // 返回上传的图片在阿里云服务器oss上的地址
            return "https://" + bucketName + "." + endpoint.replaceAll("https://", "") + "/" + fileName;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
            return null;
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
            return null;
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
