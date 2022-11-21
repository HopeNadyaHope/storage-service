package com.epam.microservices.service;

import com.epam.microservices.model.StorageEntity;
import com.epam.microservices.model.StorageModel;
import com.epam.microservices.repository.StorageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public Integer create(StorageModel storageModel) {
        StorageEntity storageEntity = modelMapper.map(storageModel, StorageEntity.class);
        repository.create(storageEntity);
        return storageEntity.getId();
    }

    public List<StorageModel> read() {
        return repository.read()
                .stream()
                .map(storageEntity -> modelMapper.map(storageEntity, StorageModel.class))
                .collect(toList());
    }

    public List<Integer> delete(List<Integer> ids) {
        List<Integer> deletedIds = new ArrayList<>();
        ids.forEach(id -> {
            Optional<StorageEntity> fileEntity = repository.read(id);
            if (fileEntity.isPresent()) {
                repository.delete(fileEntity.get());
                deletedIds.add(id);
            }
        });
        return deletedIds;
    }
}
