package com.silveo.inmemorydb.service;

import com.silveo.inmemorydb.model.Model;

import java.util.List;

public interface AccountService {
    List<Model> findAllModels();

    Model saveModel(Model model);

    Model findByAccount(Long account);

    List<Model> findByName(String name);

    List<Model> findByValue(Double value);

    Model updateModel(Model model);

    void deleteModel(Long account);
}
