package com.epam.microservices.repository;

import com.epam.microservices.model.StorageEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class StorageRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    public void create(StorageEntity storageEntity) {
        entityManager.persist(storageEntity);
    }

    public List<StorageEntity> read() {
        return entityManager.createNamedQuery("getAllStorages", StorageEntity.class).getResultList();
    }

    public Optional<StorageEntity> read(Integer id) {
        return Optional.ofNullable(entityManager.find(StorageEntity.class, id));
    }

    @Transactional
    public void delete(StorageEntity storageEntity) {
        entityManager.remove(entityManager.contains(storageEntity) ? storageEntity : entityManager.merge(storageEntity));
    }
}
