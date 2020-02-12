package Model;

import java.util.Date;

public class Ressenti {

    private Date date;
    private RessentiEmotion mEmotion;
    private RessentiPhysique mPhysique;
    private RessentiCorps mCorps;

    public Ressenti(Date date, RessentiEmotion ressentiEmotion, RessentiPhysique ressentiPhysique, RessentiCorps ressentiCorps){
        this.mCorps = ressentiCorps;
        this.date = date;
        this.mEmotion = ressentiEmotion;
        this.mPhysique = ressentiPhysique;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public RessentiEmotion getEmotion() {
        return mEmotion;
    }

    public void setEmotion(RessentiEmotion emotion) {
        mEmotion = emotion;
    }

    public RessentiPhysique getPhysique() {
        return mPhysique;
    }

    public void setPhysique(RessentiPhysique physique) {
        mPhysique = physique;
    }

    public RessentiCorps getCorps() {
        return mCorps;
    }

    public void setCorps(RessentiCorps corps) {
        mCorps = corps;
    }
}
