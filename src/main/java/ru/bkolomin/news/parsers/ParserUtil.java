package ru.bkolomin.news.parsers;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.bkolomin.news.model.NewsItem;
import ru.bkolomin.news.repository.NewsRepository;

import java.util.ArrayList;

public class ParserUtil {

    public static String getFirstElementText(Elements elements){
        Element element = elements.first();

        if(element == null){
            return "";
        }else {
            return element.text();
        }
    }

    public static String getFirstElementUrl(Elements elements){
        Element element = elements.first();

        if(element == null){
            return "";
        }else {
            return element.absUrl("href");
        }
    }

    public static void parseAllNews(NewsRepository newsRepository){
        ArrayList<Parser> parsers = new ArrayList<>();

        parsers.add(new ParserHabr());
        parsers.add(new ParserD3());

        for(Parser parser: parsers) {

            ArrayList<NewsItem> newsItems = new ArrayList<>();

            parser.getNewPages(newsItems);

            for(NewsItem newsItem: newsItems){
                newsRepository.save(newsItem);
            }

        }

    }

}
