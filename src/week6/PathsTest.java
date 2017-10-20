package week6;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;

public class PathsTest {

    public static void main(String[] args) throws IOException, URISyntaxException {

                    // 1 method
        // InputStream inputStream = new URL("http://football.ua/").openStream();
        // Path asd = Paths.get("23");
        // Files.copy(inputStream, asd);
        // List<String> sdf = Files.readAllLines(asd);
        // System.out.println(sdf);
        //
        
                    // 2 method
        
//        URL url = new URL("http://football.ua/");
//        Path path = Paths.get(url.toURI());
//        List<String> sdf = Files.readAllLines(path);
//        System.out.println(sdf);

        
                    //3 method
        
        // String urlString = "http://football.ua/";
//         URI uri = URI.create(urlString);
        // Path path = Paths.get(uri);
        // String sdf = Files.lines(path).reduce("", (l1, l2) -> l1 + "\n" + l2);
        // System.out.println(sdf);
    }

    public static void copy(Matcher matcher) {

        int i = 0;
        String url;
        while (matcher.find()) {
            url = matcher.group();
            try {
                if (url.endsWith(".png"))
                    Files.copy(getInputStream(url), Paths.get(i++ + ".png"));
                else
                    Files.copy(getInputStream(url), Paths.get(i++ + ".jpg"));
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    public static InputStream getInputStream(String url) {
        try {
            return new URL(url).openStream();
        } catch (IOException e) {
            e.getMessage();
            return null;
        }

    }

}
