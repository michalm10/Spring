package ug.app.service;

import org.springframework.stereotype.Service;
import ug.app.domain.Brand;
import ug.app.domain.Smartphone;
import ug.app.repository.BrandRepository;
import ug.app.repository.SmartphoneRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class SmartphoneManagerImpl implements SmartphoneManager {
    private final BrandRepository brandRepository;
    private final SmartphoneRepository smartphoneRepository;

    public SmartphoneManagerImpl(BrandRepository b, SmartphoneRepository s) {
        brandRepository = b;
        smartphoneRepository = s;
    }

    private final List<Smartphone> smartphones = new ArrayList<>();
    @Override
    public Smartphone add(Smartphone smartphone) {
        Smartphone smartphoneToAdd = new Smartphone(
            UUID.randomUUID().toString(),
            smartphone.getModel(),
            smartphone.getBrand(),
            smartphone.getStorage(),
            smartphone.getRAM()
        );
        smartphones.add(smartphoneToAdd);
        return smartphoneToAdd;
    }

    @Override
    public Smartphone update(Smartphone smartphone, String id) {
        Smartphone found = null;
        for (Smartphone s : smartphones)
            if (s.getId().equals(id)) found = s;
        if (found != null) {
            //found.setBrand(smartphone.getBrand());
            found.setModel(smartphone.getModel());
            found.setStorage(smartphone.getStorage());
            found.setRAM(smartphone.getRAM());
        }
        return found;
    }

    @Override
    public List<Smartphone> getAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public boolean delete(String id) {
        Smartphone found = null;
        for (Smartphone s : smartphones)
            if (s.getId().equals(id)) found = s;
        if (found != null) {
            smartphones.remove(found);
            return true;
        }
        return false;
    }

    @Override
    public Smartphone getById(String id) {
        Smartphone found = null;
        return smartphoneRepository.findById(1L).get();
    }

    public void learning() {
        var b1 = new Brand();
        var s1 = new Smartphone(UUID.randomUUID().toString(), "asdf" , b1, 135, 43);
        var s2 = new Smartphone(UUID.randomUUID().toString(), "fdsa" , b1, 135, 43);
        var s3 = new Smartphone(UUID.randomUUID().toString(), "fdsa" , b1, 143, 9);
        var s4 = new Smartphone(UUID.randomUUID().toString(), "fdsa" , b1, 143, 1);
        var ss = smartphoneRepository.save(s3);
        smartphoneRepository.save(s4);
        var smartpones = new ArrayList<Smartphone>();
        smartpones.add(s1);
        smartpones.add(s2);
        b1.setSmartphones(smartpones);
        b1.setName("Huawei");

        var b_saved = brandRepository.save(b1);

        Optional<Brand> b_found = brandRepository.findById(b_saved.getId());
        b_found.ifPresent(System.out::println);

        smartphoneRepository.findByModelOrStorage("asdf", 143).forEach(System.out::println);
        smartphoneRepository.findByModel("fdsa").forEach(System.out::println);

        var ret_s = smartphoneRepository.findById(ss.getIId());
        System.out.println(ret_s.get().getBrand());

        for (Smartphone smartphone : smartphoneRepository.findAll()) {
            System.out.println(smartphone.getModel());
            System.out.println(smartphone.getBrand().getName());
        }
    }
}
