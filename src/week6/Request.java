package week6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Request {

    public static InputStream getStream(String urlString) {

        try {
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();
            return urlConnection.getInputStream();
        } catch (IOException e) {
            e.getMessage();
            return null;
        }
    }

    public static String getString(InputStream stream) {

        Scanner scanner = new Scanner(stream);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return stringBuilder.toString();
    }

    public static void download(Matcher matcher) {

        int i = 1;
        String url;
        InputStream inputStream;
        FileOutputStream fileOutputStream;

        while (matcher.find()) {
            url = matcher.group();
            inputStream = getStream(url);

            try {
                if (url.endsWith(".png"))
                    fileOutputStream = new FileOutputStream(i++ + ".png");
                else
                    fileOutputStream = new FileOutputStream(i++ + ".jpg");
                int size = 1024;
                byte[] buff = new byte[size];
                int readed = 0;
                while ((readed = inputStream.read(buff, 0, size)) != -1) {
                    fileOutputStream.write(buff, 0, readed);
                }
                fileOutputStream.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }

    }

}
