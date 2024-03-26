package travel.tours;

import travel.abstracttours.Tour;

import java.io.Serializable;

public class RelaxationTour extends Tour implements Serializable {
    private static final long serialVersionUID = 1L;

    public RelaxationTour(){
        super();
    }

    public RelaxationTour(String destination, String transport, String accommodation, int duration, double price) {
        super("Отдых", destination, transport, accommodation, duration, price);
    }

    @Override
    public String toString() {
        return "Тип тура: Релаксационный\n" +
                "Страна: " + getDestination() + "\n" +
                "Транспорт: " + getTransport() + "\n" +
                "Проживание: " + getAccommodation() + "\n" +
                "Продолжительность (дни): " + getDuration() + "\n" +
                "Цена: " + getPrice() + "\n";
    }
}
