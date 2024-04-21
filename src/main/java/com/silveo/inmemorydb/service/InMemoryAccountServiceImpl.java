package com.silveo.inmemorydb.service;

import com.silveo.inmemorydb.model.Model;
import com.silveo.inmemorydb.repository.InMemoryModelDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryAccountServiceImpl implements AccountService{
    private final InMemoryModelDAO repository;
    @Override
    public List<Model> findAllModels() {
        return repository.findAllAccounts();
    }

    @Override
    public Model saveModel(Model model) {
        return repository.saveAccount(model);
    }

    @Override
    public Model findByAccount(Long account) {
        return repository.findByAccount(account);
    }

    @Override
    public List<Model> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Model> findByValue(Double value) {
        return repository.findByValue(value);
    }

    @Override
    public Model updateModel(Model model) {
        return repository.updateAccount(model);
    }

    @Override
    public void deleteModel(Long account) {
        repository.deleteAccount(account);
    }
}
