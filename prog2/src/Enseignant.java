public class Enseignant extends Person {
    private String specialite;

    public Enseignant(int id, String nom, String prenom, LocalDate dateNaissance,
                      String email, String telephone, String specialite) {
        super(id, nom, prenom, dateNaissance, email, telephone);
        this.specialite = specialite;
    }

    public String getSpecialite() { return specialite; }
}