package cl.ucn.disc.dam.discnews.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import cl.ucn.disc.dam.discnews.model.Article;
import cl.ucn.disc.dam.discnews.model.NewsApi;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Clase principal que contiene los metodos de acceso a las noticias
 */

public class NewsController {

    /**
     * URL desde donde se obtendran los {@link Article}.
     */
    final String url = "https://newsapi.org/v1/articles?source=national-geographic&sortBy=top&apiKey=ed6bb68169694928beada76957626d34";

    /**
     * Des-Serializador GSON
     */
    private static final Gson gson = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting() // TODO: Eliminar en modo produccion
            .create();

    /**
     * Cliente OkHttp
     */
    private final OkHttpClient client = new OkHttpClient();

    /**
     *Obtencion de {@link Article}s desde Internet.
     *
     * @return the {@link List} of {@Link Article}.
     */

    public List<Article> getArticles() throws IOException{
        //Peticion
        final Request request = new Request.Builder()
                .url(url)
                .build();

        //Respuesta
        final Response response = client.newCall(request).execute();
        final String json = response.body().string();

        final NewsApi newsapi = gson.fromJson(json,NewsApi.class);

        return newsapi.getArticles();
    }
}
