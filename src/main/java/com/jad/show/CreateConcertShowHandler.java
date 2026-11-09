package com.jad.show;

import java.util.Map;

final class CreateConcertShowHandler extends CreateShowHandler {
    CreateConcertShowHandler() {
        super(ShowType.CONCERT);
    }

    @Override
    public IShow handle(final String showDescription) {
        if (!this.canHandle(showDescription)) {
            return this.handleNext(showDescription);
        }
        final Map<String, String> parameters = parseParameters(showDescription);
        return ShowFactory.makeConcertShow(
                getRequired(parameters, "name"),
                getRequired(parameters, "description"),
                getRequired(parameters, "artist"));
    }
}
