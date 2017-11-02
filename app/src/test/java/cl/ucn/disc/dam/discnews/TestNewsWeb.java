package cl.ucn.disc.dam.discnews;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;

import cl.ucn.disc.dam.discnews.model.NewsApi;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Clase para probar la conexion
 */
public class TestNewsWeb {
    /**
     * Des-Serializador GSON
     */
    private static final Gson gson = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting() // TODO: Eliminar en modo produccion
            .create();

    @Test
    public void testConnection() throws IOException{
        final String url = "https://newsapi.org/v1/articles?source=national-geographic&sortBy=top&apiKey=ed6bb68169694928beada76957626d34";

        final OkHttpClient client = new OkHttpClient();
        Assertions.assertThat(client).isNotNull();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Assertions.assertThat(request).isNotNull();

        Response response = client.newCall(request).execute();
        final String json = response.body().string();

        System.out.println(json);
        Assertions.assertThat(json).isNotBlank();

        //des-serialisar
        final NewsApi newsapi = gson.fromJson(json,NewsApi.class);
        Assertions.assertThat(newsapi).isNotNull();
        System.out.print(newsapi);

    }
}
