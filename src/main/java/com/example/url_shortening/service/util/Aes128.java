package com.example.url_shortening.service.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Aes128 {

    public  String encrypt(String input, String key){
        byte[] crypted = null;

        try{
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(),"AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,skey);
            crypted = cipher.doFinal(input.getBytes());

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        BASE64Encoder encoder = new BASE64Encoder();
        String result = encoder.encode(crypted);

        return result;
    }

    public  String decrypt(String input, String key){
        byte[] output = null;
        try{
            BASE64Decoder decoder = new BASE64Decoder();
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(),"AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCSPadding");
            cipher.init(Cipher.DECRYPT_MODE,skey);
            output = cipher.doFinal(decoder.decodeBuffer(input));


        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return new String(output);
    }
}
