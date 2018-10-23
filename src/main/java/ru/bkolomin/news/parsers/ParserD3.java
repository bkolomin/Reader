package ru.bkolomin.news.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.bkolomin.news.model.NewsItem;

import java.util.List;

public class ParserD3 extends Parser {

    @Override
    public void getNewPages(List<NewsItem> list ) {

        Document doc;

        try {
            doc = Jsoup.connect("https://politota.d3.ru/rss/").get();
        } catch (Exception ex) {
            return;
        }

        Elements postPreviews = doc.select("item");

        for (Element postPreview : postPreviews) {

            String post_title   =  ParserUtil.getFirstElementText(postPreview.select("title"));
            String post_a       =  ParserUtil.getFirstElementText(postPreview.select("link"));
            String post_text    =  "";

            list.add(new NewsItem("Habr", post_title, post_text, post_a));
        }

    }

}
