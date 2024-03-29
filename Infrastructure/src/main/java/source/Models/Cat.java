package source.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cats_main_info")
public class Cat implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id", nullable = false)
    private Integer id;
    @Column(name = "cat_name", unique = true)
    private String name;
    @Column(name = "cat_birthday", nullable = false)
    private LocalDate birthDate;
    @Column(name = "cat_breed", nullable = false)
    private String breed;
    @Column(name = "cat_color" ,nullable = false)
    @Enumerated(EnumType.STRING)
    private CatColor color;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinTable(name = "cats_friends",
            joinColumns = @JoinColumn(name = "cat_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private Set<Cat> friends = new HashSet<>();

    public void addFriend(Cat cat) {
        friends.add(cat);
        cat.getFriends().add(this);
    }

    public void removeFriend(Cat cat) {
        friends.remove(cat);
        cat.getFriends().remove(this);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
