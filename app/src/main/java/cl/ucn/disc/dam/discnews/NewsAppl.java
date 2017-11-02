package cl.ucn.disc.dam.discnews;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import java.io.IOException;
import java.util.List;

import cl.ucn.disc.dam.discnews.controller.NewsController;
import cl.ucn.disc.dam.discnews.model.Article;

/**
 * Clase que carga las noticias en segundo plano
 */

public class NewsAppl extends AsyncTask<Void,Void,Void> {
    private ArrayAdapter<Article> adapter;
    private List<Article> articles;
    private Context context;

    public NewsAppl(Context context, ArrayAdapter<Article> adapter){
        this.adapter = adapter;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        final NewsController nc = new NewsController();
        try {
            articles = nc.getArticles();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // Añadimos todos los links al Adapter.
        for (Article tmp : articles)
            adapter.add(tmp);

        // Indicamos al Adapter que ha cambiado su contenido, para que actualice
        // a su vez los datos mostrados en el ListView.
        adapter.notifyDataSetChanged();

        super.onPostExecute(result);
    }

}
