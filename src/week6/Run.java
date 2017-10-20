package week6;

import java.util.regex.Pattern;

public class Run {

    public static void main(String[] args) {

        String urlString = "http://football.ua/";

        Pattern pattern = Pattern.compile("(http|https|ftp)://\\S*?\\.(png|jpg)");

//        Request.download(pattern.matcher(Request.getString(Request.getStream(urlString))));
        PathsTest.copy(pattern.matcher(Request.getString(PathsTest.getInputStream(urlString))));

    }

}
