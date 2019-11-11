package demo.reactive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsItem {

    // fields related to the news item
    private String headline;
    private String description;
    private URL url;
    private Timestamp publishedDate;

    // metadata about the news item
    private Integer votes;
    private List<String> tags;
    private Timestamp createdTime;
    private Timestamp updatedTime;

    // internal metadata about the news item
    private boolean approved;

    public NewsItem(String headline, URL url, List<String> tags) {
        this.headline = headline;
        this.url = url;
        this.tags = tags;
    }
}
