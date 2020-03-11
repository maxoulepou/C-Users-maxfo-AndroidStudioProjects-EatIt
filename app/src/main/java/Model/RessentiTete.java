package Model;

public class RessentiTete extends Ressenti {

    private String emotions;

    public RessentiTete(int id, String date, String commentaire, String emotions) {
        super(id, date, commentaire);
        this.emotions = emotions;
    }

    public String getEmotions() {
        return emotions;
    }
}