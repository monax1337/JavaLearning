package travel.tours;

import travel.abstracttours.Tour;

import java.io.Serializable;

public class ExcursionTour extends Tour implements Serializable {
    private static final long serialVersionUID = 1L;


    public ExcursionTour() {
        super();
    }

    public ExcursionTour(String destination, String transport, String accommodation, int duration, double price) {
        super("Экскурсии", destination, transport, accommodation, duration, price);
    }

    @Override
    public String toString() {
        return "Тип тура: Экскурсионный\n" +
                "Страна: " + getDestination() + "\n" +
                "Транспорт: " + getTransport() + "\n" +
                "Проживание: " + getAccommodation() + "\n" +
                "Продолжительность (дни): " + getDuration() + "\n" +
                "Цена: " + getPrice() + "\n";
    }
}
