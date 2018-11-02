package ru.bkolomin.news.repository;

import jdk.nashorn.internal.objects.NativeRegExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.bkolomin.news.model.NewsItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NewsRepository {

    Map<String, NewsItem> map = new HashMap<>();

	//План доделок

    //select page.page_id, page.page_title, text.old_text from page left join text on text.old_id = page.page_latest;

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

    //private static final BeanPropertyRowMapper<Meal> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Meal.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NewsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public String getPageText(int pageId) {

        try {
            Map<String, Object> mapRes = jdbcTemplate.queryForMap("select page.page_id, page.page_title, text.old_text from page left join text on text.old_id = page.page_latest where page_id = ?", pageId);

            return new String((byte[]) mapRes.get("old_text"), "UTF-8");
        }catch(Exception ex){
            return  "error: " + ex.toString();
        }

    }

    public List<NewsItem> getAll(){
        return new ArrayList<NewsItem>(map.values());
    }

    public void save(NewsItem newsItem){
        map.put(newsItem.getUrl(), newsItem);
    }

}
