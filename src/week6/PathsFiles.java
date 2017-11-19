package week6;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;

public class PathsFiles {

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
