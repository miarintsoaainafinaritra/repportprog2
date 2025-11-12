import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Note {
    private Etudiant etudiant;
    private Examen examen;
    private double valeurActuelle;
    private List<NoteChange> historique;

    public Note(Etudiant etudiant, Examen examen, double valeurInitiale) {
        this.etudiant = etudiant;
        this.examen = examen;
        this.valeurActuelle = valeurInitiale;
        this.historique = new ArrayList<>();

        this.historique.add(new NoteChange(0, valeurInitiale, Instant.now(), "Note initiale"));
    }

    public void modifierNote(double nouvelleValeur, String motif) {
        NoteChange changement = new NoteChange(this.valeurActuelle, nouvelleValeur,
                Instant.now(), motif);
        this.historique.add(changement);
        this.valeurActuelle = nouvelleValeur;
    }

    public double getValeurA(Instant t) {
        for (int i = historique.size() - 1; i >= 0; i--) {
            NoteChange changement = historique.get(i);
            if (!changement.getDateChangement().isAfter(t)) {
                return changement.getNouvelleValeur();
            }
        }
        return 0;
    }

    public Etudiant getEtudiant() { return etudiant; }
    public Examen getExamen() { return examen; }
    public double getValeurActuelle() { return valeurActuelle; }
    public List<NoteChange> getHistorique() { return historique; }
}