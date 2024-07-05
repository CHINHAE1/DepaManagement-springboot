package org.example.depamanagement.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/5 15:24
 * @version: 1.0
 */

/*阿里云OSS相关配置*/
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {
  // 区域
  private String endpoint;
  // 身份ID
  private String accessKeyId;
  // 身份密钥
  private String accessKeySecret;
  // 存储空间
  private String bucketName;
}
