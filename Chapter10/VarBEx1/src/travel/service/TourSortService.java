package travel.service;

import travel.abstracttours.Tour;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TourSortService {
    public static List<Tour> sortByDuration(List<Tour> tours, int minDuration, int maxDuration) {
        return tours.stream()
                .filter(tour -> tour.getDuration() >= minDuration && tour.getDuration() <= maxDuration)
                .sorted(Comparator.comparingInt(Tour::getDuration))
                .collect(Collectors.toList());
    }

    public static List<Tour> sortByPrice(List<Tour> tours, double minPrice, double maxPrice) {
        return tours.stream()
                .filter(tour -> tour.getPrice() >= minPrice && tour.getPrice() <= maxPrice)
                .sorted(Comparator.comparingDouble(Tour::getPrice))
                .collect(Collectors.toList());
    }
}
