import java.util.Comparator;

public class PlacaComparator implements Comparator<String> {
    @Override
    public int compare(String placa1, String placa2) {
        return placa1.compareTo(placa2);
    }
}
