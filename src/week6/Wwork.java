package week6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Wwork {

    public static void main(String[] args) throws IOException {

        String urlString = "http://football.ua/";
        InputStream inputStream = getStream(urlString);
        Scanner scanner = new Scanner(inputStream);
        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }

        Pattern pattern = Pattern.compile("(http|https|ftp)://\\S*?\\.(png|jpg)");

        Matcher matcher = pattern.matcher(stringBuilder.toString());
        int i = 1;
        while (matcher.find()) {

            urlString = matcher.group();
            inputStream = getStream(urlString);
            
            FileOutputStream fos;

            if (urlString.endsWith(".png")) {
                fos = new FileOutputStream(i++ + ".png");
            } else {
                fos = new FileOutputStream(i++ + ".jpg");
            }
            int size = 1024;
            byte[] buff = new byte[size];

            while (inputStream.read(buff, 0, size) != -1) {
                fos.write(buff);
            }
            fos.close();

        }
    }


    public static InputStream getStream(String urlString) throws IOException {

        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();
        return urlConnection.getInputStream();
    }

}
