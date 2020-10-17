import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

/**
 * @author Musa Dzhabirov
 */

public class Main {

    private static Logger logger;
    private static String dataFile = "src/main/resources/map.json";
    private static Scanner scanner;
    private static StationIndex stationIndex;

    public static void main(String[] args) throws Exception {

        Document document = Jsoup.connect("https://coronavirus-control.ru/coronavirus-moscow/").userAgent("Chrome/86.0.4240.75 Safari/537.36").referrer("https://google.com").get();
        Elements listNews = document.select("div#coronatablerussia");

    final Integer[] count = {0};
    PrintWriter writer = new PrintWriter("data/file123.csv");

        listNews.select("th").forEach(element -> {

            writer.write(String.valueOf(element.select("th").text() + ";"));

            System.out.print(element.select("th").text() + "; ");

            count[0]++;
            if (count[0] % 7 == 0) {
                System.out.println("\n");
                writer.write("\n");
            }
        });

        writer.flush();
        writer.close();

    }

    public static String parseFile(String path) {

        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
