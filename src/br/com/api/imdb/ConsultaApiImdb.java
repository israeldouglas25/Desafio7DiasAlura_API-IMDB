package br.com.api.imdb;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApiImdb {

	public static void main(String[] args) throws Exception {

//		final String URL_GET = "http://httpbin.org/get";
//		
//		// cliente HTTP
//		HttpClient client = HttpClient.newHttpClient();
//		
//		// criar a requisição
//		HttpRequest request = HttpRequest.newBuilder()
//		          .GET()
//		          .timeout(Duration.ofSeconds(10))
//		          .uri(URI.create(URL_GET))
//		          .build();
//		
//		// enviando uma solicitação
//		HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
//		
//		//imprimir o conteúdo recebido
//		System.out.println(response.statusCode());
//		System.out.println(response.body());
//
//		==============================================================================================
		
		// chave para utilizar a API IMDB
		String apiKey = "k_t6g1hx9p"; 
		// Atribuindo a uma variavel do tipo URI, a URL concatenada a chave da API
		URI apiIMDB = URI.create("https://imdb-api.com/en/API/Top250TVs/" + apiKey);
		// Criando a instancia HttpClient
		HttpClient client = HttpClient.newHttpClient();
		// Criando a requisição
		HttpRequest request = HttpRequest.newBuilder()
				.uri(apiIMDB)
				.build();
		// Enviando uma solicitação
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		// Atribuindo a resposta do Json a uma variavel tipo String
		String json = response.body();
		//imprimir o conteúdo recebido
		System.out.println("Resposta: " + json);


	}

}
