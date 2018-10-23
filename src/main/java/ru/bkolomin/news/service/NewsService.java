package ru.bkolomin.news.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bkolomin.news.model.NewsItem;
import ru.bkolomin.news.parsers.ParserUtil;
import ru.bkolomin.news.repository.NewsRepository;

import java.util.List;

@Service
public class NewsService {

    NewsRepository repository;

    @Autowired
    public NewsService(NewsRepository repository) {
        this.repository = repository;
    }

    public void parseAllNews(){

        ParserUtil.parseAllNews(repository);

    }

    public List<NewsItem> getAll(){

        return repository.getAll();

    }

}
