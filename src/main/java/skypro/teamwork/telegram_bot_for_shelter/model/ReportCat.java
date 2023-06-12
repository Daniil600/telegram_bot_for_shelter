package skypro.teamwork.telegram_bot_for_shelter.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ReportCat {
    @Id
    @GeneratedValue(generator = "reportcat_seq")
    private long id;
    @OneToOne
    private PhotoCatsReport photoCatsReport;
    private String diet;
    private String health;
    private String habits;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_id")
    private Cat cat;

    public ReportCat(long id, PhotoCatsReport photoCatsReport, String diet, String health, String habits, Cat cat) {
        this.id = id;
        this.photoCatsReport = photoCatsReport;
        this.diet = diet;
        this.health = health;
        this.habits = habits;
        this.cat = cat;
    }

    public ReportCat() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PhotoCatsReport getPhotoCatsReport() {
        return photoCatsReport;
    }

    public void setPhotoCatsReport(PhotoCatsReport photoCatsReport) {
        this.photoCatsReport = photoCatsReport;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReportCat)) return false;
        ReportCat reportCat = (ReportCat) o;
        return Objects.equals(photoCatsReport, reportCat.photoCatsReport) && Objects.equals(diet, reportCat.diet) && Objects.equals(health, reportCat.health) && Objects.equals(habits, reportCat.habits) && Objects.equals(cat, reportCat.cat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoCatsReport, diet, health, habits, cat);
    }

    @Override
    public String toString() {
        return "ReportCat{" +
                "photoCatsReport=" + photoCatsReport +
                ", diet='" + diet + '\'' +
                ", health='" + health + '\'' +
                ", habits='" + habits + '\'' +
                ", cat=" + cat +
                '}';
    }
}
