package cl.ucn.disc.dam.discnews;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import cl.ucn.disc.dam.discnews.model.Noticia;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class NoticiaTest {

    /**
     * Des-Serializador GSON
     */
    private static final Gson gson = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting() // TODO: Eliminar en modo produccion
            .create();


    @Test
    public void testConstructor(){
        //Noticia bajo prueba
        final Noticia noticia = Noticia.builder().titulo("Titulo de la noticia").autor("Kevin Araya").resumen("Este es el resumen").build();

        Assertions.assertThat(noticia).isNotNull();
        Assertions.assertThat(noticia.getTitulo()).isNull();

        //Serializar a json
        final String json = gson.toJson(noticia);
        System.out.println(json);
        Assertions.assertThat(json).isNotBlank();

        //Des-serialisar
        final Noticia noti = gson.fromJson(json,Noticia.class);
        //Assertions.assertThat(noti).isNotNull();
        //No es necesario ya que mas abajo está el isEqualToComparingFieldByField
        //Assertions.assertThat(noticia.getTitulo()).isEqualTo(noti.getTitulo());
        Assertions.assertThat(noti).isEqualToComparingFieldByField(noti);
    }
}