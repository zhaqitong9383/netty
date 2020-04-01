package com.baiwang.platform.dao;
import com.baiwang.cloud.common.exception.SystemException;
import org.apache.commons.lang3.StringUtils;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

import java.util.Scanner;

/**
 * @program: JasyptUtils
 * @description: TODO
 * @author: shiqiang
 * @create: 2020-02-10 10:03
 **/
public class JasyptUtils {

    /**
     * Jasypt生成加密结果
     *
     * @param password 配置文件中设定的加密密码 jasypt.encryptor.password
     * @param value    待加密值
     * @return
     */
    public static String encryptPwd(String password, String value) {
        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();
        encryptOr.setConfig(cryptOr(password));
        String result = encryptOr.encrypt(value);
        return result;
    }

    /**
     * 解密
     *
     * @param password 配置文件中设定的加密密码 jasypt.encryptor.password
     * @param value    待解密密文
     * @return
     */
    public static String decyptPwd(String password, String value) {
        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();
        encryptOr.setConfig(cryptOr(password));
        String result = encryptOr.decrypt(value);
        return result;
    }

    public static SimpleStringPBEConfig cryptOr(String password) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm(StandardPBEByteEncryptor.DEFAULT_ALGORITHM);
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        return config;
    }

    public static void main(String[] args) {
        // 加密
        String passwd = "baiwang*58";
        passwd = scanner("加密密钥");
        System.out.println(encryptPwd(passwd, scanner("用户名")));
        System.out.println(encryptPwd(passwd, scanner("数据库密码")));
        // 解密
        // System.out.println(decyptPwd(passwd, "7FfRHng2xeeCcnnTzeDC6g=="));
        // System.out.println(decyptPwd(passwd, "ssoMvEuLONS2IoExnYFl7g=="));
    }

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }

        throw new SystemException( "9999","请输入正确的" + tip + "！");
    }
}
