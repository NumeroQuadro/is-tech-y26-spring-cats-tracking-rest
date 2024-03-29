package source.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class OwnerCatsID implements Serializable {
    @Column(name = "owner_id")
    private Integer ownerId;

    @Column(name = "cat_id")
    private Integer catId;

    public OwnerCatsID() {
    }

    public OwnerCatsID(Integer ownerId, Integer catId) {
        this.ownerId = ownerId;
        this.catId = catId;
    }
}