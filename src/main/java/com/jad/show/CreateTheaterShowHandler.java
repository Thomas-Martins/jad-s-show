package com.jad.show;

import java.util.Map;

final class CreateTheaterShowHandler extends CreateShowHandler {
    CreateTheaterShowHandler() {
        super(ShowType.THEATER);
    }

    @Override
    public IShow handle(final String showDescription) {
        if (!this.canHandle(showDescription)) {
            return this.handleNext(showDescription);
        }
        final Map<String, String> parameters = parseParameters(showDescription);
        return ShowFactory.makeTheaterShow(
                getRequired(parameters, "name"),
                getRequired(parameters, "description"),
                getRequired(parameters, "director"),
                getList(parameters, "actors"));
    }
}
