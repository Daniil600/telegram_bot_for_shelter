package skypro.teamwork.telegram_bot_for_shelter.model.volunteer;


import skypro.teamwork.telegram_bot_for_shelter.model.user.User;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "volunteer")
public class Volunteer {
    @Id
    @GeneratedValue(generator = "volunteer_seq")
    private Long id;
    private String name;
    private boolean active;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Volunteer(Long id, String name, boolean active, User user) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.user = user;
    }

    public Volunteer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volunteer volunteer = (Volunteer) o;
        return active == volunteer.active && Objects.equals(id, volunteer.id) && Objects.equals(name, volunteer.name) && Objects.equals(user, volunteer.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, active, user);
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", user=" + user +
                '}';
    }
}
