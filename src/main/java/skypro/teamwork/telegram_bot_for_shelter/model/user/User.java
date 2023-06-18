package skypro.teamwork.telegram_bot_for_shelter.model.user;


import skypro.teamwork.telegram_bot_for_shelter.model.pet.Pet;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

/**
 * Класс описывает таблицу user
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    private Long id;
    private String name;
    private LocalDateTime useDateTime;

    /**
     * к одному пользователю может быть прикреплены несколько питомцев, зависимость OneToMany
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<Pet> pet;

    private String contact;

    public User(Long id, String name, LocalDateTime useDateTime, Collection<Pet> pet, String contact) {
        this.id = id;
        this.name = name;
        this.useDateTime = useDateTime;
        this.pet = pet;
        this.contact = contact;
    }

    public User() {
    }

    public Long getChatId() {
        return id;
    }

    public void setChatId(Long chatId) {
        this.id = chatId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getUseDateTime() {
        return useDateTime;
    }

    public void setUseDateTime(LocalDateTime useDateTime) {
        this.useDateTime = useDateTime;
    }

    public Collection<Pet> getPet() {
        return pet;
    }

    public void setPet(Collection<Pet> pet) {
        this.pet = pet;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(useDateTime, user.useDateTime) && Objects.equals(pet, user.pet) && Objects.equals(contact, user.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, useDateTime, pet, contact);
    }
}
