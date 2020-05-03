package cn.tedu.cloud_note.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class NoteUtil {

    /**
     * 将传入的src加密处理
     *
     * @param src：明文字符串
     * @return 返回加密后的字符串结果
     * @throws NoSuchAlgorithmException
     */
    public static String md5(String src) {
        /*
         * 将字符串信息采用MD5处理
         */
        try {
            // 3.获取MessageDigest对象
            String algorithm = "md5";

            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

            // 4.获取明文字符串对应的字节数组
            byte[] input = src.getBytes();

            // 5.执行加密
            byte[] output = messageDigest.digest(input);

            // 6.创建BigInteger对象
            int signum = 1;
            BigInteger bigInteger = new BigInteger(signum, output);

            // 7.按照16进制将bigInteger的值转换为字符串
            int radix = 16;
            String encoded = bigInteger.toString(radix).toUpperCase();

            return encoded;
        } catch (Exception e) {
            throw new NoteException("加密异常", e);
        }
    }

    /*
     * 利用UUID算法生成主键
     */
    public static String createId() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        return id.replace("-", "");
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(md5("123456"));
//		System.out.println(md5("456"));
        System.out.println(createId());
        System.out.println(md5(createId()));

    }
}
