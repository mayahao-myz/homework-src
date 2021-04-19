package com.mayazhao.homework.encrypt;

import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.jupiter.api.Test;

public class Encrypt {
    @Test
    public void druidEncrypt() throws Exception {
        //密码明文
        String username = "root";
        String password = "19991119";
        System.out.println("明文用户名：" + username);
        System.out.println("明文密码: " + password);
        String[] keyPair = ConfigTools.genKeyPair(512);
        //私钥
        String privateKey = keyPair[0];
        //公钥
        String publicKey = keyPair[1];

        //用私钥加密后的密文
        password = ConfigTools.encrypt(privateKey, password);
        username = ConfigTools.encrypt(privateKey,username);
        System.out.println("privateKey:" + privateKey);
        System.out.println("publicKey:" + publicKey);
        System.out.println("username:" + username);
        System.out.println("password:" + password);

        String decryptUserName = ConfigTools.decrypt(publicKey,username);
        String decryptPassword = ConfigTools.decrypt(publicKey, password);
        System.out.println("解密用户名：" + decryptUserName);
        System.out.println("解密后密码:" + decryptPassword);
    }
}
