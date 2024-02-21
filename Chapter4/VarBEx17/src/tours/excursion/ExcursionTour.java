package tours.excursion;

import tours.Tour;

public class ExcursionTour extends Tour {
    public ExcursionTour(String transport, String meals, int duration) {
        super("Excursion", transport, meals, duration);
    }
}
