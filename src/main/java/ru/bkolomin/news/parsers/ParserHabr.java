package ru.bkolomin.news.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.bkolomin.news.model.NewsItem;

import java.util.List;

public class ParserHabr extends Parser {

    @Override
    public void getNewPages(List<NewsItem> list ) {

        Document doc;

        for(int page = 1; page <= 5; page++) {

            try {
                doc = Jsoup.connect(String.format("https://habr.com/all/page%d/", page)).get();
            } catch (Exception ex) {
                return;
            }


            Elements postPreviews = doc.select(".post_preview");

            for (Element postPreview : postPreviews) {

                String post_title   =  ParserUtil.getFirstElementText(postPreview.select(".post__title a"));
                String post_a       =  ParserUtil.getFirstElementUrl(postPreview.select(".post__title a"));
                String post_text    =  ParserUtil.getFirstElementText(postPreview.select(".post__text"));

                list.add(new NewsItem("Habr", post_title, post_text, post_a));
            }

        }

    }

}
