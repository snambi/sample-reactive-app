package demo.reactive;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ReactiveNewsRepository implements NewsRepository {

    private static List<NewsItem> news = new ArrayList<>();

    static{
        try {

            news.add( new NewsItem("Great election", new URL("http://www.google.com"), Arrays.asList("Politics")));
            news.add( new NewsItem("Big Storm", new URL("http://www.google.com"), Arrays.asList("Weather")));
            news.add( new NewsItem("Large fire", new URL("http://www.google.com"), Arrays.asList("Weather")));
            news.add( new NewsItem("Stock crash", new URL("http://www.google.com"), Arrays.asList("Finance")));
            news.add( new NewsItem("Holiday Ideas", new URL("http://www.google.com"), Arrays.asList("Events")));
            news.add( new NewsItem("Diwali Sales", new URL("http://www.google.com"), Arrays.asList("Commerce")));
            news.add( new NewsItem("Movies week", new URL("http://www.google.com"), Arrays.asList("Movies")));
            news.add( new NewsItem("President trump", new URL("http://www.google.com"), Arrays.asList("Politics")));
            news.add( new NewsItem("PG&E", new URL("http://www.google.com"), Arrays.asList("Finance")));


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Flux<NewsItem> findAll() {
        return Flux.fromIterable(news).delayElements(Duration.ofMillis(20));
    }

    @Override
    public List<NewsItem> findAllNews() {
        return news;
    }

}
