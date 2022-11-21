package com.epam.microservices.controller;

import com.epam.microservices.model.StorageModel;
import com.epam.microservices.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/storages")
public class StorageController {
    private static final String ID = "id";
    @Autowired
    private StorageService service;

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Integer> create(@Valid @RequestBody StorageModel storageModel) {
        int createdResourceId = service.create(storageModel);
        return Map.of(ID, createdResourceId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StorageModel> read() {
        return service.read();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, List<Integer>> delete(@PathVariable(name = "id") List<Integer> ids) {
        return Map.of(ID, service.delete(ids));
    }

}
