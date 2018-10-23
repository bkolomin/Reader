package ru.bkolomin.news;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.bkolomin.news.model.NewsItem;
import ru.bkolomin.news.parsers.Parser;
import ru.bkolomin.news.parsers.ParserD3;

import java.util.ArrayList;

//https://jsoup.org/apidocs/index.html?org/jsoup/select/Selector.html


public class Main {

    public static void main(String [] args){

        ArrayList<NewsItem> newsItems = new ArrayList<>();


        Parser parser = new ParserD3();
        parser.getNewPages(newsItems);


        for(NewsItem newsItem: newsItems){

            System.out.println(newsItem);

        }

    }

}
