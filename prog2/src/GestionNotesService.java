import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class GestionNotesService {
    private List<Note> notes;
    private Examen exam;
    private Instant t;
    private Etudiant Etudiant;

    public GestionNotesService() {
        this.notes = new ArrayList<>();
    }

    public void ajouterNote(Note note) {
        notes.add(note);
    }

    public double getExamGrade(Examen exam,Etudiant Etudiant, Instant t) {
        this.exam = exam;
        this.Etudiant = Etudiant;
        this.t = t;
        for (Note note : notes) {
            if (note.getExamen().equals(exam) && note.getEtudiant().equals(Etudiant)) {
                return note.getValeurA(t);
            }
        }
        return 0;
    }

    public double getCourseGrade(Cours course, Etudiant Etudiant, Instant t) {
        double sommeNotesPonderees = 0;
        int sommeCoefficients = 0;

        for (Note note : notes) {
            if (note.getEtudiant().equals(Etudiant) &&
                    note.getExamen().getCours().equals(course)) {

                double noteExamen = note.getValeurA(t);
                int coefficient = note.getExamen().getCoefficient();

                sommeNotesPonderees += noteExamen * coefficient;
                sommeCoefficients += coefficient;
            }
        }

        return sommeCoefficients > 0 ? sommeNotesPonderees / sommeCoefficients : 0;
    }

    public List<Note> getNotes() { return notes; }
}