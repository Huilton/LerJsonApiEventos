import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class Main implements Serializable {

	public static void main(String[] args) throws IOException {

		URL urlJson = new URL("http://localhost:8080/evento");

		Gson gson = new Gson();

		JsonElement jsonElement = gson.fromJson(new InputStreamReader(urlJson.openStream()), JsonElement.class);

		Type tipoLista = new TypeToken<ArrayList<Evento>>() {
		}.getType();

		List<Evento> listaEventos = gson.fromJson(jsonElement, tipoLista);

		for (Evento evento : listaEventos) {

			System.out.println("Evento Convertido: " + evento.toString());
		}

	}

}
