package ru.bkolomin.news.repository;

import jdk.nashorn.internal.objects.NativeRegExp;
import ru.bkolomin.news.model.NewsItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsRepository {

    Map<String, NewsItem> map = new HashMap<>();

	//План доделок
	
	//убрать ДатаПоследнегоЗаказа, Колонки, РасшифроватьПродажиПоПериодам
	//Колонки_ABCКласс, дней с последнйе продажи, Колонки_MAX_Расшифровка ещё используются
	
	//Вихров
	//Вин10 на флешку
	//https://habr.com/post/120101/
	//https://habr.com/post/243431/
	//https://habr.com/post/222579/
	//https://www.youtube.com/watch?v=BmBr5diz8WA
	//https://postgrespro.ru/education/books
	//https://spring.io/projects/spring-boot
	//https://stackoverflow.com/questions/tagged/spring one-by-one +java +etc
	//https://habr.com/company/luxoft/blog/157273/
	//https://habr.com/company/microsoft/blog/415189/
	//https://habr.com/company/lanit/blog/426171/
	//https://www.youtube.com/watch?v=D5RlTEtr-MY
	//https://habr.com/post/426741/
	//https://habr.com/post/427223/
	//https://www.viva64.com/ru/b/0391/
	//https://habr.com/company/ruvds/blog/427293/
	//https://habr.com/company/maxilect/blog/427307/
	

    public void NewsRepository(){
    }

    public List<NewsItem> getAll(){
        return new ArrayList<NewsItem>(map.values());
    }

    public void save(NewsItem newsItem){
        map.put(newsItem.getUrl(), newsItem);
    }

}
