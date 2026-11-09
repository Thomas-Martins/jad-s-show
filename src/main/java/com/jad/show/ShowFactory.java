package com.jad.show;

public abstract class ShowFactory  {

    public static IShow makeMovieShow(final String name, final String description, final String director, final String yearOfRelease, final MovieType movieType){
        return new MovieShow(name, description, director, yearOfRelease, movieType);
    }

    public static IShow makeTheaterShow(final String name, final String description, final String director, String... actors){
        return new TheaterShow(name, description, director, actors);
    }

    public static IShow makeStreetShow(final String name, final String description, final String... performers){
        return new StreetShow(name, description, performers);
    }

    public static IShow makeConcertShow(final String name, final String description, final String artist){
        return new ConcertShow(name, description, artist);
    }
}
