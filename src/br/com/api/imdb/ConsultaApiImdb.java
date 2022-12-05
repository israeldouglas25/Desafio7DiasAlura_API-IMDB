package br.com.api.imdb;

import java.util.List;
import java.util.Map;

import br.com.api.imdb.service.API;
import br.com.api.imdb.service.ParseJsonMovies;

public class ConsultaApiImdb {

	public static void main(String[] args) throws Exception {

		// Instanciando as class
		API api = new API();
		ParseJsonMovies parser = new ParseJsonMovies();
		
		// Incluindo a api já parseada numa lista com o MAP
		List<Map<String, String>> listaFilmes = parser.parse(api.jsonApi());

		// Mostrando apenas o que é necessario
		for (Map<String, String> filme : listaFilmes) {
			System.out.println("Titulo: " + filme.get("title") + " | Ano: " + filme.get("year"));
			System.out.println("Imagem: " + filme.get("image"));
			System.out.println("Nota: " + filme.get("imDbRating"));
			System.out.println();
		}

	}

}
