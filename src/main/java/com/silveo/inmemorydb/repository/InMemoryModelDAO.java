package com.silveo.inmemorydb.repository;

import com.silveo.inmemorydb.model.Model;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryModelDAO {
    private final ConcurrentHashMap<Long, Model> modelsByAccount = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, List<Model>> modelsByName = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Double, List<Model>> modelsByValue = new ConcurrentHashMap<>();

    public List<Model> findAllAccounts(){
        return new ArrayList<>(modelsByAccount.values());
    }

    public Model saveAccount(Model model){
        modelsByAccount.put(model.getAccount(), model);
        modelsByName.computeIfAbsent(model.getName(), k -> new ArrayList<>()).add(model);
        modelsByValue.computeIfAbsent(model.getValue(), k -> new ArrayList<>()).add(model);
        return model;
    }

    public Model findByAccount(Long account){
        return modelsByAccount.get(account);
    }

    public List<Model> findByName(String name){
        return modelsByName.getOrDefault(name, Collections.emptyList());
    }

    public List<Model> findByValue(Double value){
        return modelsByValue.getOrDefault(value, Collections.emptyList());
    }

    public Model updateAccount(Model model){
        Model existingModel = modelsByAccount.replace(model.getAccount(), model);
        if(existingModel != null){
            modelsByName.get(existingModel.getName()).remove(existingModel);
            modelsByValue.get(existingModel.getValue()).remove(existingModel);
            modelsByName.computeIfAbsent(model.getName(), k -> new ArrayList<>()).add(model);
            modelsByValue.computeIfAbsent(model.getValue(), k -> new ArrayList<>()).add(model);
        }
        return model;
    }

    public void deleteAccount(Long account){
        Model model = modelsByAccount.remove(account);
        if(model != null){
            modelsByName.get(model.getName()).remove(model);
            modelsByValue.get(model.getValue()).remove(model);
        }
    }
}

