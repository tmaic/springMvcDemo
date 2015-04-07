package com.demo.domain.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;

/**
 * Created with IntelliJ IDEA.
 * User: meichao
 * Date: 2015/4/3
 * Time: 15:38
 * Desc:
 * To change this template use File | Settings | File Templates.
 */
public class DesEncrypt {

    private byte[] desKey;

    public DesEncrypt(String desKey) {
        this.desKey = desKey.getBytes();
    }

    public DesEncrypt() {
    }

    public byte[] desEncrypt(byte[] plainText) throws Exception {
        SecureRandom sr = new SecureRandom();
        byte rawKeyData[] = desKey;
        DESKeySpec dks = new DESKeySpec(rawKeyData);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key, sr);
        byte data[] = plainText;
        byte encryptedData[] = cipher.doFinal(data);
        return encryptedData;
    }

    public byte[] desDecrypt(byte[] encryptText) throws Exception {
        SecureRandom sr = new SecureRandom();
        byte rawKeyData[] = desKey;
        DESKeySpec dks = new DESKeySpec(rawKeyData);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, key, sr);
        byte encryptedData[] = encryptText;
        byte decryptedData[] = cipher.doFinal(encryptedData);
        return decryptedData;
    }

    /**
     * 解密
     * @param input
     * @return
     * @throws Exception
     */
    public String encrypt(String input) throws Exception {
        return base64Encode(desEncrypt(input.getBytes()));
    }

    /**
     * 加密
     * @param input
     * @return
     * @throws Exception
     */
    public String decrypt(String input) throws Exception {
        byte[] result = base64Decode(input);
        return new String(desDecrypt(result));
    }

    public static String base64Encode(byte[] s) {
        if (s == null)
            return null;
        BASE64Encoder b = new sun.misc.BASE64Encoder();
        return b.encode(s);
    }

    public static byte[] base64Decode(String s) throws IOException {
        if (s == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = decoder.decodeBuffer(s);
        return b;
    }
    public byte[] getDesKey() {
        return desKey;
    }

    public void setDesKey(byte[] desKey) {
        this.desKey = desKey;
    }

    public static void main(String[] args) throws Exception {
        String key = "test-yunfeixian";
        String input = "22401_20130913134520";
        DesEncrypt crypt = new DesEncrypt(key);
        //加密
        System.out.println("Encode:" + crypt.encrypt(input));
        //解密
//        System.out.println("Decode:" + crypt.decrypt("oTNH3lU56e0t6fGn+hTLChteLS3ZFa4h"));
    }
}
