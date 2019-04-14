package unittest.service;

import unittest.repository.RemoteStringRepository;
import unittest.repository.Repository;

public class DataService {
    private Repository<String> stringRepository;

    public DataService() {
        stringRepository = new RemoteStringRepository();
    }

    public DataService(Repository<String> repository) {
        this.stringRepository = repository;
    }

    public String saveAndLoad(String string) {
        stringRepository.save(string);
        return stringRepository.load();
    }
}
