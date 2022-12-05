package br.com.api.imdb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Movie {

	private List<String> title = new ArrayList<>();
	private List<String> urlImage = new ArrayList<>();
	private List<String> rating = new ArrayList<>();
	private List<String> year = new ArrayList<>();

	public Movie() {
	}

	public Movie(String[] movie) {
		this.title = parseTitles(movie);
		this.year = parseYear(movie);
		this.urlImage = parseUrlImages(movie);
		this.year = parseRating(movie);
	}

	public List<String> getTitle() {
		return  title;
	}

	public List<String> getUrlImage() {
		return urlImage;
	}

	public List<String> getRating() {
		return rating;
	}

	public List<String> getYear() {
		return year;
	}

	public List<String> parseTitles(String[] moviesArray) {
		return parseAttribute(moviesArray, 2);
	}

	public List<String> parseYear(String[] moviesArray) {
		return parseAttribute(moviesArray, 4);
	}

	public List<String> parseUrlImages(String[] moviesArray) {
		return parseAttribute(moviesArray, 5);
	}

	public List<String> parseCrew(String[] moviesArray) {
		return parseAttribute(moviesArray, 6);
	}

	public List<String> parseRating(String[] moviesArray) {
		return parseAttribute(moviesArray, 7);
	}

	public List<String> parseAttribute(String[] moviesArray, int pos) {
		return Stream.of(moviesArray)
				.map(e -> e.split("\",\"")[pos])
				.map(e -> e.split(":\"")[1])
				.map(e -> e.replaceAll("\"", ""))
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "title: " + title 
				+ "\nurlImage: " + urlImage 
				+ "\nrating: " + rating 
				+ "\nyear: " + year ;
	}

}
