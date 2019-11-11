package demo.reactive;

import reactor.core.publisher.Flux;

import java.util.List;

public interface NewsRepository {

    Flux<NewsItem> findAll();

    List<NewsItem> findAllNews();
}
