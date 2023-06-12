package skypro.teamwork.telegram_bot_for_shelter.model.cat;


import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cat")
public class Cat {

    @Id
    @GeneratedValue(generator = "cat_seq")
    private Long id;
    private String catPassport;
    private String name;
    @OneToOne
    private PhotoCats photoCats;
    private Date dateOfAdoption;
    private String description;
    @OneToMany(mappedBy = "cat", fetch = FetchType.LAZY)
    private Collection<ReportCat> reportCats;

    public Cat(Long id, String catPassport, String name, PhotoCats photoCats, String description) {
        this.id = id;
        this.catPassport = catPassport;
        this.name = name;
        this.photoCats = photoCats;
        this.description = description;
    }

    public Cat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatPassport() {
        return catPassport;
    }

    public void setCatPassport(String catPassport) {
        this.catPassport = catPassport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhotoCats getPhotoCats() {
        return photoCats;
    }

    public void setPhotoCats(PhotoCats photoCats) {
        this.photoCats = photoCats;
    }

    public Date getDateOfAdoption() {
        return dateOfAdoption;
    }

    public void setDateOfAdoption(Date dateOfAdoption) {
        this.dateOfAdoption = dateOfAdoption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<ReportCat> getReportCats() {
        return reportCats;
    }

    public void setReportCats(Collection<ReportCat> reportCats) {
        this.reportCats = reportCats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return Objects.equals(id, cat.id) && Objects.equals(catPassport, cat.catPassport) && Objects.equals(name, cat.name) && Objects.equals(photoCats, cat.photoCats) && Objects.equals(dateOfAdoption, cat.dateOfAdoption) && Objects.equals(description, cat.description) && Objects.equals(reportCats, cat.reportCats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, catPassport, name, photoCats, dateOfAdoption, description, reportCats);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", catPassport='" + catPassport + '\'' +
                ", name='" + name + '\'' +
                ", photoCats=" + photoCats +
                ", dateOfAdoption=" + dateOfAdoption +
                ", description='" + description + '\'' +
                ", reportCats=" + reportCats +
                '}';
    }
}
