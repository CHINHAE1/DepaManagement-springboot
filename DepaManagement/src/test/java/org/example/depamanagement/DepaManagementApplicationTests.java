package org.example.depamanagement;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class DepaManagementApplicationTests {

    @Test
    public void testUuid(){
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    @Test
    public void genJwt(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","Tom");

        String jwt = Jwts.builder()
                .setClaims(claims) //自定义内容(载荷)
                .signWith(SignatureAlgorithm.HS256, "itheima") //签名算法
                .setExpiration(new Date(System.currentTimeMillis() + 24*3600*1000)) //有效期
                .compact();

        System.out.println(jwt);
        // 输出结果:
        // eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzIwMjUyOTIxLCJ1c2VybmFtZSI6IlRvbSJ9.TcagNMTQd-L7V0zWU-7XY-V798E2mjeEue-VTsptrcc

    }

    @Test
    public void parseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")//指定签名密钥（必须保证和生成令牌时使用相同的签名密钥）
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzIwMjUyOTIxLCJ1c2VybmFtZSI6IlRvbSJ9.TcagNMTQd-L7V0zWU-7XY-V798E2mjeEue-VTsptrcc")
                .getBody();

        System.out.println(claims);
    }

}
