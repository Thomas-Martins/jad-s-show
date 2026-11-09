package com.jad.customer;

import java.util.ArrayList;
import java.util.List;

import com.jad.show.ConcertShow;
import com.jad.show.IShow;
import com.jad.show.MovieShow;
import com.jad.show.StreetShow;
import com.jad.show.TheaterShow;

public class Spectator implements ISpectator, IVisitor {
    private final String firstName;
    private final String lastName;

    public Spectator(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void watch(final IShow show) {
        show.accept(this);
    }

    @Override
    public void handleMovieShow(MovieShow movieShow) {
        System.out.println("J'ai assisté au film " + movieShow.getName() + " de " + movieShow.getDirector() + " sorti en " + movieShow.getYearOfRelease());
        System.out.println();
    }

    @Override
    public void handleConcertShow(ConcertShow concertShow) {
        System.out.println("J'ai assisté au concert " + concertShow.getName() + " de " + concertShow.getArtist());
        System.out.println();
    }

    @Override
    public void handleTheaterShow(TheaterShow theaterShow) {
        String sentence1 = "J'ai assisté à la pièce de théâtre " + theaterShow.getName() + " de " + theaterShow.getDirector() + ".";

        String sentence2 = "Il y avait : ";
        for (String actor : theaterShow.getActors()) {
            sentence2 += actor + ", ";
        }

        System.out.println(sentence1);
        System.out.println(sentence2);
        System.out.println();
    }

    @Override
    public void handleStreetShow(StreetShow streetShow) {
        String sentence1 = "J'ai assisté au spectacle de rue " + streetShow.getName() + ".";
        String sentence2 = "Il y avait : ";

        for(String performer: streetShow.getPerformers()){
            sentence2 += performer + ", " ;
        }

        System.out.println(sentence1);
        System.out.println(sentence2);
        System.out.println();
    }
}
