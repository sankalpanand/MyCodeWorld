package Leetcode.Medium;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class EncodeDecodeTinyURL {



    public static void main(String[] args) throws Exception {
//        String shortUrl = "http://tinyurl.com/4e9iAk";
//        System.out.println(shortUrl.substring(shortUrl.length()-6, shortUrl.length()));

        System.out.println(String.valueOf(9));
    }


    static MessageDigest md;
    static Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            return null;
        }
        md.update(longUrl.getBytes());
        byte byteData[] = md.digest();
        String myHash = DatatypeConverter.printHexBinary(byteData).substring(0, 6);
        if(!map.containsKey(myHash)) {
            map.put(myHash, longUrl);
        }
        return "http://tinyurl.com/" + myHash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String keyword = shortUrl.substring(shortUrl.length()-6, shortUrl.length());
        if(map.containsKey(keyword)) {
            return map.get(keyword);
        } else {
            return null;
        }
    }
}
