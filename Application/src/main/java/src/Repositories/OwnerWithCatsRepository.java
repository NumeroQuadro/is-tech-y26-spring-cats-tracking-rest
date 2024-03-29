package src.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import source.Models.OwnerCatsID;
import source.Models.OwnerWithCats;

public interface OwnerWithCatsRepository extends JpaRepository<OwnerWithCats, OwnerCatsID> {

}
