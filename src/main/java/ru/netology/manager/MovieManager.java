package ru.netology.manager;
import ru.netology.domain.Movie;

public class MovieManager {

    private Movie[] movies = new Movie[0];
    private final int defaultValueLength;

    {
        defaultValueLength = 10;
    }

    private int valueLength;


    public MovieManager() {
    }

    public MovieManager(int valueLength) {
        this.valueLength = valueLength;
    }
    public void addFilm(Movie movie) {
        int length = movies.length + 1;
        Movie[] films = new Movie[length];
        System.arraycopy(movies, 0, films, 0, movies.length);
        int lastIndex = films.length - 1;
        films[lastIndex] = movie;
        movies = films;
    }
    public Movie[] getLastFilms() {
        int currentValueLight = movies.length;
        if (valueLength == 0) {
            if (defaultValueLength < currentValueLight) {
                currentValueLight = defaultValueLength;
            }
        } else {
            if (valueLength < currentValueLight) {
                currentValueLight = valueLength;
            }
        }
        Movie[] result = new Movie[currentValueLight];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - 1 - i;
            result[i] = movies[index];
        }
        return result;
    }
}
