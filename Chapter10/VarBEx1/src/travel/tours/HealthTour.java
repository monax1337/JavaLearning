package travel.tours;

import travel.abstracttours.Tour;

import java.io.Serializable;

public class HealthTour extends Tour implements Serializable {
    private static final long serialVersionUID = 1L;

    public HealthTour() {
        super();
    }

    public HealthTour(String destination, String transport, String accommodation, int duration, double price) {
        super("Лечение", destination, transport, accommodation, duration, price);
    }

    @Override
    public String toString() {
        return "Тип тура: Оздоровительный\n" +
                "Страна: " + getDestination() + "\n" +
                "Транспорт: " + getTransport() + "\n" +
                "Проживание: " + getAccommodation() + "\n" +
                "Продолжительность (дни): " + getDuration() + "\n" +
                "Цена: " + getPrice() + "\n";
    }
}
