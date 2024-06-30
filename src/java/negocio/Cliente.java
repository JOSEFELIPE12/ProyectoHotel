package negocio;


public class Cliente {
    private String dni;
    private String nom;
    private String pas;

    public Cliente() {
    }

    public Cliente(String dni, String nom, String pas) {
        this.dni = dni;
        this.nom = nom;
        this.pas = pas;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }
    
    
}