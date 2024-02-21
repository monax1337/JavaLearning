package appmain;

import offerings.Offerings;
import tours.excursion.ExcursionTour;
import tours.medical.MedicalTour;
import tours.relaxation.RelaxationTour;

import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        Offerings offerings = new Offerings();

        RelaxationTour relaxationTour = new RelaxationTour("Plane", "All inclusive", 7);
        ExcursionTour excursionTour = new ExcursionTour("Bus", "Half board", 5);
        MedicalTour medicalTour = new MedicalTour("Train", "Full board", 14);

        offerings.addOffering(relaxationTour);
        offerings.addOffering(excursionTour);
        offerings.addOffering(medicalTour);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter preferred mode of transport (Plane, Bus, Train):");
        String transport = scanner.nextLine();
        offerings.filterByTransport(transport);

        System.out.println("Enter minimum duration of the tour (in days):");
        int minDuration = scanner.nextInt();
        System.out.println("Enter maximum duration of the tour (in days):");
        int maxDuration = scanner.nextInt();
        offerings.filterByDuration(minDuration, maxDuration);

        scanner.close();

        //offerings.displayOfferings();
    }
}
