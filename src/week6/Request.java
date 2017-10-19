package week6;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Request {

    public static InputStream getStream(String urlString) throws IOException {

//        try {
//            URL url = new URL(urlString);
//            URLConnection urlConnection = url.openConnection();
//            System.out.println("df");
//            return urlConnection.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
      URL url = new URL(urlString);
      URLConnection urlConnection = url.openConnection();
      System.out.println("df");
      return urlConnection.getInputStream();

    }

    public static String getString(InputStream stream) {

        Scanner scanner = new Scanner(stream);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine()).append("\n");
        }
        String sd = stringBuilder.toString();
//        System.out.println(sd);
        return sd;
    }

}
