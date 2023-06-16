package skypro.teamwork.telegram_bot_for_shelter.model.pet;

import javax.persistence.*;
import java.util.Objects;

/**
 * Этот класс описывает таблицу report_pet
 * в него складываются отчеты по питомцам, присланные усыновителями животных в течение испытательного срока
 */
@Entity
@Table(name = "report_pet")
public class ReportPet {
    @Id
    @GeneratedValue(generator = "report_pet_seq")
    private long id;

    /**
     * к каждому отчету прикладывается фото питомца, зависимость OneToOne
     */
    @OneToOne
    private PhotoPetReport photoPetReport;
    private String rept;

    /**
     * Отчет привязан к конкретному питомцу, у каждого питомца множество отчетов, зависимость ManyToOne
     * привязка к колонке pet_id из таблицы pet
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public ReportPet(long id, PhotoPetReport photoPetReport, String rept, Pet pet) {
        this.id = id;
        this.photoPetReport = photoPetReport;
        this.rept = rept;
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

    public String getRept() {
        return rept;
    }

    public void setRept(String rept) {
        this.rept = rept;
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
        return Objects.equals(photoPetReport, reportPet.photoPetReport) && Objects.equals(rept, reportPet.rept) && Objects.equals(pet, reportPet.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoPetReport, rept, pet);
    }

    @Override
    public String toString() {
        return "ReportPet{" +
                "photoPetsReport=" + photoPetReport+
                ", rept='" + rept + '\'' +
                ", pet=" + pet +
                '}';
    }
}
