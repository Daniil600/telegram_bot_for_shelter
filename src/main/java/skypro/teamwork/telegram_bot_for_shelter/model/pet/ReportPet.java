package skypro.teamwork.telegram_bot_for_shelter.model.pet;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "report_pet")
public class ReportPet {
    @Id
    @GeneratedValue(generator = "report_pet_seq")
    private long id;
    @OneToOne
    private PhotoPetReport photoPetReport;
    private String diet;
    private String health;
    private String habits;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public ReportPet(long id, PhotoPetReport photoPetReport, String diet, String health, String habits, Pet pet) {
        this.id = id;
        this.photoPetReport = photoPetReport;
        this.diet = diet;
        this.health = health;
        this.habits = habits;
        this.pet = pet;
    }

    public ReportPet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PhotoPetReport getPhotoPetsReport() {
        return photoPetReport;
    }

    public void setPhotoPetsReport(PhotoPetReport photoPetReport) {
        this.photoPetReport = photoPetReport;
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReportPet)) return false;
        ReportPet reportPet = (ReportPet) o;
        return Objects.equals(photoPetReport, reportPet.photoPetReport) && Objects.equals(diet, reportPet.diet) && Objects.equals(health, reportPet.health) && Objects.equals(habits, reportPet.habits) && Objects.equals(pet, reportPet.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoPetReport, diet, health, habits, pet);
    }

    @Override
    public String toString() {
        return "ReportPet{" +
                "photoPetsReport=" + photoPetReport+
                ", diet='" + diet + '\'' +
                ", health='" + health + '\'' +
                ", habits='" + habits + '\'' +
                ", pet=" + pet +
                '}';
    }
}
