package com.jad.show;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class CreateShowHandler {
    private final ShowType showTypeHandled;
    private CreateShowHandler nextHandler;

    public CreateShowHandler(final ShowType showTypeHandled) {
        this.showTypeHandled = showTypeHandled;
    }

    public ShowType getShowTypeHandled() {
        return this.showTypeHandled;
    }

    public abstract IShow handle(final String showDescription);

    public CreateShowHandler getNextHandler() {
        return this.nextHandler;
    }

    public boolean hasNextHandler() {
        return this.nextHandler != null;
    }

    public void addHandler(final CreateShowHandler nextHandler) {
        if (this.hasNextHandler()) {
            this.nextHandler.addHandler(nextHandler);
        } else {
            this.nextHandler = nextHandler;
        }
    }

    protected boolean canHandle(final String showDescription) {
        return this.showTypeHandled.name().equals(extractType(showDescription));
    }

    protected IShow handleNext(final String showDescription) {
        if (this.hasNextHandler()) {
            return this.nextHandler.handle(showDescription);
        }
        throw new IllegalArgumentException("Aucun maillon ne sait créer ce show : " + showDescription);
    }

    private static String extractType(final String showDescription) {
        final int separatorIndex = showDescription.indexOf(':');
        if (separatorIndex < 0) {
            throw new IllegalArgumentException("Description invalide (type manquant) : " + showDescription);
        }
        return showDescription.substring(0, separatorIndex).trim();
    }

    protected static Map<String, String> parseParameters(final String showDescription) {
        final Map<String, String> parameters = new LinkedHashMap<>();
        final String content = showDescription.substring(showDescription.indexOf(':') + 1);
        for (final String pair : content.split(";")) {
            if (pair.isBlank()) {
                continue;
            }
            final int equalsIndex = pair.indexOf('=');
            if (equalsIndex < 0) {
                throw new IllegalArgumentException("Paramètre invalide (« = » manquant) : " + pair);
            }
            parameters.put(pair.substring(0, equalsIndex).trim(), pair.substring(equalsIndex + 1).trim());
        }
        return parameters;
    }

    protected static String getRequired(final Map<String, String> parameters, final String key) {
        final String value = parameters.get(key);
        if (value == null) {
            throw new IllegalArgumentException("Paramètre manquant : " + key);
        }
        return value;
    }

    protected static String[] getList(final Map<String, String> parameters, final String key) {
        final String[] values = getRequired(parameters, key).split(",");
        for (int i = 0; i < values.length; i++) {
            values[i] = values[i].trim();
        }
        return values;
    }
}
