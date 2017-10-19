package week6;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Run {
    
    public static void main(String[] args) throws IOException{
        
        String urlString = "http://football.ua/";
        InputStream inputStream = Request.getStream(urlString);

        Pattern pattern = Pattern.compile("(http|https|ftp)://\\S*?\\.(png|jpg)");
        
        Matcher matcher = pattern.matcher(Request.getString(inputStream));
        System.out.println(Request.getString(inputStream));
        
//        int i = 1;
//        while (matcher.find()) {
//
//            urlString = matcher.group();
//            inputStream = Request.getStream(urlString);
//            System.out.println(urlString);
//            
//            FileOutputStream fos;
//
//            if (urlString.endsWith(".png")) {
//                fos = new FileOutputStream(i++ + ".png");
//            } else {
//                fos = new FileOutputStream(i++ + ".jpg");
//            }
//            int size = 1024;
//            byte[] buff = new byte[size];
//
//            while (inputStream.read(buff, 0, size) != -1) {
//                fos.write(buff);
//            }
//            fos.close();
//
//        }

        
        
        
    }

}
