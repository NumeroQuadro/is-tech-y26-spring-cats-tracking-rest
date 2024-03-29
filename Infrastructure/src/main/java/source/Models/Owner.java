package source.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id", nullable = false)
    private Integer id;
    @Column(name = "owner_name", nullable = false, unique = true)
    private String name;
    @Column(name = "owner_birthday", nullable = false)
    private LocalDate birthDate;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cat> cats = new HashSet<>();

    public Owner(String name, LocalDate birthDate, Set<Cat> cats) {
        this.name = name;
        this.birthDate = birthDate;
        this.cats = cats;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", catsCount=" + (cats != null ? cats.size() : "null") +
                ", catNames=[" + (cats != null ? cats.stream().map(Cat::getName).collect(Collectors.joining(", ")) : "null") + "]" +
                '}';
    }
}
