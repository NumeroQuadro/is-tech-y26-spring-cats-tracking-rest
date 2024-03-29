package src.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import source.Models.Owner;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Optional<Owner> findByName(String ownerName);
}
