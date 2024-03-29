package src.Services;

import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;
import source.Models.CatsWithFriends;
import src.Repositories.CatRepository;
import source.Models.Cat;
import source.Models.CatColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.Repositories.OwnerRepository;
import src.Repositories.OwnerWithCatsRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class CatService {
    @Autowired
    private CatRepository catRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private OwnerWithCatsRepository ownerWithCatsRepository;

    public void addCatToMainTable(String catName, String catBreed, LocalDate catBirthday, CatColor catColor) {
        var cat = new Cat();
        cat.setName(catName);
        cat.setBreed(catBreed);
        cat.setBirthDate(catBirthday);
        cat.setColor(catColor);
        catRepository.save(cat);
    }

    public void deleteCatFromMainTable(String catName) {
        var cat = catRepository.findByName(catName);

        if (cat.isPresent()) {
            cat.ifPresent(catRepository::delete);
        }

    }

    @Transactional
    public void addFriendToCat(String catName, String friendName) {
        var cat = catRepository.findByName(catName);
        var friendCat = catRepository.findByName(friendName);

        if (friendCat.isPresent()) {
            var friendCatValue = friendCat.get();
            cat.ifPresent(value -> value.addFriend(friendCatValue));
            cat.ifPresent(catRepository::save);
        }
    }

    public Collection<Cat> getAllBlackCats() {
        var cat = new Cat();
        cat.setColor(CatColor.black);
        var example = Example.of(cat);

        return catRepository.findAll(example);
    }

    public Collection<Cat> getAllCatsOwnedByOwner(String ownerName) {
        var owner = ownerRepository.findByName(ownerName);
        if (owner.isPresent()) {
            var ownerValue = owner.get();
            return ownerValue.getCats();
        }

        return new ArrayList<>();
    }

    public Collection<Cat> listCatsFromMainTable() {
        return catRepository.findAll();
    }
}
