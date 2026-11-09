package com.jad.show;

import java.util.Map;

final class CreateStreetShowHandler extends CreateShowHandler {
    CreateStreetShowHandler() {
        super(ShowType.STREET_SHOW);
    }

    @Override
    public IShow handle(final String showDescription) {
        if (!this.canHandle(showDescription)) {
            return this.handleNext(showDescription);
        }
        final Map<String, String> parameters = parseParameters(showDescription);
        return ShowFactory.makeStreetShow(
                getRequired(parameters, "name"),
                getRequired(parameters, "description"),
                getList(parameters, "performers"));
    }
}
