package ru.bkolomin.news.web;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bkolomin.news.model.NewsItem;
import ru.bkolomin.news.repository.NewsRepository;
import ru.bkolomin.news.service.NewsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewsServlet extends HttpServlet {

    private ConfigurableApplicationContext springContext;
    private NewsService newsController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        springContext = new ClassPathXmlApplicationContext("spring-app.xml", "spring-db.xml");

        newsController = springContext.getBean(NewsService.class);

        newsController.parseAllNews();
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String text = newsController.getPageText(18);

        NewsItem newsItem = new NewsItem("advice", "18", text, "");

        List<NewsItem> newsList = new ArrayList<>();

        newsList.add(newsItem);


        request.setAttribute("news", newsList);

        request.getRequestDispatcher("/news.jsp").forward(request, response);


        /*List<NewsItem> newsList = newsController.getAll();

        request.setAttribute("news", newsList);

        request.getRequestDispatcher("/news.jsp").forward(request, response);
        */
    }
}