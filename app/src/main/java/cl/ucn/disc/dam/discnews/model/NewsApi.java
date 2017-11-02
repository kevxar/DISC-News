package cl.ucn.disc.dam.discnews.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;

/**
 * Api de News
 */

@Builder
public class NewsApi {

    @Getter
    private String status;
    @Getter
    private String source;
    @Getter
    private String sortBy;
    @Getter
    private List<Article> articles = null;
    @Getter
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public void setStatus(String status) {
        this.status = status;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
