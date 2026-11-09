package com.jad.show;

public final class CreateShowHandlerChain extends CreateShowHandler {
    private static final CreateShowHandlerChain INSTANCE = new CreateShowHandlerChain();

    private CreateShowHandlerChain() {
        super(ShowType.OTHER);
        this.addHandler(new CreateMovieShowHandler());
        this.addHandler(new CreateTheaterShowHandler());
        this.addHandler(new CreateStreetShowHandler());
        this.addHandler(new CreateConcertShowHandler());
    }

    public static CreateShowHandlerChain getInstance() {
        return INSTANCE;
    }

    @Override
    public IShow handle(final String showDescription) {
        return this.handleNext(showDescription);
    }
}
