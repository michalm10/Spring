package ug.app.service;

import ug.app.domain.Smartphone;

import java.util.List;

public interface SmartphoneManager {
        Smartphone add(Smartphone smartphone);
        Smartphone update(Smartphone smartphone, String id);
        List<Smartphone> getAll();
        boolean delete(String id);
        Smartphone getById(String id);
        void learning();
}
