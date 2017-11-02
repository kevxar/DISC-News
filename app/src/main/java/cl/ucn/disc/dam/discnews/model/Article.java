package cl.ucn.disc.dam.discnews.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;

/**
 * Clase generada via http://www.jsonschema2pojo.org/
 */
@Builder
public class Article {

    @Getter
    private String author;
    @Getter
    private String title;
    @Getter
    private String description;
    @Getter
    private String url;
    @Getter
    private String urlToImage;
    @Getter
    private String publishedAt;
    @Getter
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public void setAuthor(String author) {
        this.author = author;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
