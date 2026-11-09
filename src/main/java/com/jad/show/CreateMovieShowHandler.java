package com.jad.show;

import java.util.Map;

final class CreateMovieShowHandler extends CreateShowHandler {
    CreateMovieShowHandler() {
        super(ShowType.MOVIE);
    }

    @Override
    public IShow handle(final String showDescription) {
        if (!this.canHandle(showDescription)) {
            return this.handleNext(showDescription);
        }
        final Map<String, String> parameters = parseParameters(showDescription);
        return ShowFactory.makeMovieShow(
                getRequired(parameters, "name"),
                getRequired(parameters, "description"),
                getRequired(parameters, "director"),
                getRequired(parameters, "yearOfRelease"),
                MovieType.valueOf(getRequired(parameters, "movieType")));
    }
}
