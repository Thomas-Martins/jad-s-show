package com.jad.customer;

import com.jad.show.ConcertShow;
import com.jad.show.MovieShow;
import com.jad.show.StreetShow;
import com.jad.show.TheaterShow;

public interface IVisitor {
    void handleMovieShow(MovieShow movieShow);
    void handleConcertShow(ConcertShow concertShow);
    void handleTheaterShow(TheaterShow theaterShow);
    void handleStreetShow(StreetShow streetShow);
}
