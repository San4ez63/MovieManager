package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MovieManagerControlValueLengthTest {

    Movie first = new Movie(1, "Бладшот", "https://", "боевик");
    Movie second = new Movie(2, "Вперёд", "https://", "мультфильм");
    Movie third = new Movie(3, "Отель Белград", "https://", "комедия");
    Movie fourth = new Movie(4, "Джентльмены", "https://", "боевик");
    Movie fifth = new Movie(5, "Человек-Невидимка", "https://", "ужасы");
    Movie sixth = new Movie(6, "Тролли. Мировой тур", "https://", "мультфильм");
    Movie seventh = new Movie(7, "Номер один", "https://", "комедия");
    Movie eighth = new Movie(8, "Довод", "https://", "боевик");
    Movie ninth = new Movie(9, "Стрельцов", "https://", "мелодрама");
    Movie tenth = new Movie(10, "Гипноз", "https://", "триллер");
    Movie eleventh = new Movie(11, "2040: Будущее ждёт", "https://", "документальный");


    @Test
    public void shouldCheckControlValueLength() {
        MovieManager manager = new MovieManager(5);

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);


        Movie[] actual = manager.getLastFilms();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldCheckValueMoreControlLength() {
        MovieManager manager = new MovieManager(11);

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);


        Movie[] actual = manager.getLastFilms();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckValueLessControlLength() {
        MovieManager manager = new MovieManager(0);

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);

        Movie[] actual = manager.getLastFilms();
        Movie[] expected = new Movie[]{third, second, first};

        assertArrayEquals(expected, actual);
    }
}
