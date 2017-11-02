package cl.ucn.disc.dam.discnews;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    private ListView news;
    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView news = findViewById(android.R.id.list);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, new ArrayList());
        news.setAdapter(adapter);
        NewsAppl application = new NewsAppl(this,adapter);
        application.execute();

    }


}
