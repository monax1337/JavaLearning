package travel.service;

import travel.abstracttours.Tour;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TourConnectorService {
    private final String FILE_PATH;

    public TourConnectorService(String filePath) {
        this.FILE_PATH = filePath;
    }

    public void saveTours(List<Tour> tours) {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream(FILE_PATH)))) {
            xmlEncoder.writeObject(tours);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Tour> loadTours() {
        List<Tour> tours = new ArrayList<>();
        try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(
                new FileInputStream(FILE_PATH)))) {
            Object obj = xmlDecoder.readObject();
            if (obj instanceof List<?> rawList) {
                for (Object o : rawList) {
                    if (o instanceof Tour) {
                        tours.add((Tour) o);
                    } else {
                        System.err.println("Неожиданный тип объекта в списке: " + o.getClass().getName());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return tours;
    }
}
