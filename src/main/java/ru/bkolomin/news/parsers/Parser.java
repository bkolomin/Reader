package ru.bkolomin.news.parsers;

import ru.bkolomin.news.model.NewsItem;

import java.util.List;

public abstract class Parser {

    public abstract void getNewPages(List<NewsItem> list);

}