package src.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import source.Models.Cat;
import source.Models.Owner;
import source.Models.OwnerCatsID;
import source.Models.OwnerWithCats;
import src.Repositories.CatRepository;
import src.Repositories.OwnerRepository;
import src.Repositories.OwnerWithCatsRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private CatRepository catRepository;
    @Autowired
    private OwnerWithCatsRepository ownerWithCatsRepository;

    @Transactional
    public void addOwnerWithInitialCats(String ownerName, LocalDate ownerBirthday, Collection<String> catsNames) {
        Set<Cat> catsSet = new HashSet<>();
        var owner = new Owner(ownerName, ownerBirthday, catsSet);

        for (String catName : catsNames) {
            var catValue = catRepository.findByName(catName);

            if (catValue.isPresent()) {
                Cat cat = catValue.get();
                catsSet.add(cat);

            } else {
                throw new IllegalArgumentException("Cat with name " + catName + " not found");
            }
        }

        ownerRepository.save(new Owner(ownerName, ownerBirthday, catsSet));

        Set<Cat> saveCatsSet = new HashSet<>();
        for (String catName : catsNames) {
            var catValue = catRepository.findByName(catName);

            if (catValue.isPresent()) {
                Cat cat = catValue.get();
                saveCatsSet.add(cat);
            }
        }


        for (Cat cat : saveCatsSet) {
            ownerRepository.findByName(ownerName).ifPresent(ownerValue -> {
                OwnerCatsID id = new OwnerCatsID(ownerValue.getId(), cat.getId());
                var ownerWithCats = new OwnerWithCats(id, ownerValue, cat);
                ownerWithCatsRepository.save(ownerWithCats);
            });
        }
    }

    public void addOwnerWithoutCats(String ownerName, LocalDate ownerBirthday) {
        ownerRepository.save(new Owner(ownerName, ownerBirthday, new HashSet<>()));
    }
}
