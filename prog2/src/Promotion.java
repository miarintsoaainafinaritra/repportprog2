import java.util.ArrayList;
import java.util.List;

public class Promotion {
    private List<String> groupes;

    public Promotion() {
        this.groupes = new ArrayList<>();
    }

    public void ajouterGroupe(String groupe) {
        groupes.add(groupe);
    }

    public boolean contientGroupe(String groupe) {
        return groupes.contains(groupe);
    }

    public List<String> getGroupes() { return groupes; }
}