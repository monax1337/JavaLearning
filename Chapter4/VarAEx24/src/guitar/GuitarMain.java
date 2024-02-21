package guitar;

public class GuitarMain {
    public static void main(String[] args) {
        GuitarString string = new GuitarString("Nylon");
        Bridge bridge = new Bridge("Fixed");

        Guitar guitar = new Guitar(string, bridge);

        guitar.play();
        guitar.tune();
        guitar.replaceString(new GuitarString("Steel"));
        System.out.println(guitar.toString());
    }
}
