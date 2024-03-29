package source.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Table(name = "owners_with_cats")
@Getter
@Setter
public class OwnerWithCats implements BaseEntity<OwnerCatsID> {
    @EmbeddedId
    private OwnerCatsID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", insertable = false, updatable = false)
    private Owner owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id", insertable = false, updatable = false)
    private Cat cat;

    public OwnerWithCats() { }

    @Override
    public String toString() {
        return "OwnerWithCats{" +
                "id=" + id +
                ", owner=" + owner +
                ", cat=" + cat +
                '}';
    }
}