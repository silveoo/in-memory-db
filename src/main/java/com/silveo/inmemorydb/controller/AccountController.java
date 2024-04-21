package com.silveo.inmemorydb.controller;

import com.silveo.inmemorydb.model.Model;
import com.silveo.inmemorydb.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("")
    public List<Model> findAllModels(){
        return accountService.findAllModels();
    }

    @PostMapping("/add")
    public Model saveModel(@RequestBody Model model){
        return accountService.saveModel(model);
    }

    @GetMapping("/find-by-account/{account}")
    public Model findByAccount(@PathVariable Long account){
        return accountService.findByAccount(account);
    }

    @GetMapping("/find-by-name/{name}")
    public List<Model> findByName(@PathVariable String name){
        return accountService.findByName(name);
    }

    @GetMapping("/find-by-value/{value}")
    public List<Model> findByValue(@PathVariable Double value){
        return accountService.findByValue(value);
    }

    @PutMapping("/update")
    public Model updateModel(@RequestBody Model model){
        return accountService.updateModel(model);
    }

    @DeleteMapping("/delete/{account}")
    public void deleteModel(@PathVariable Long account){
        accountService.deleteModel(account);
    }
}
