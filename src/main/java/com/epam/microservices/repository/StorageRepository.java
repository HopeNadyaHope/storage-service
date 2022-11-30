package com.epam.microservices.repository;

import com.epam.microservices.model.StorageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class StorageRepository {

    private final Logger logger = LoggerFactory.getLogger(StorageRepository.class);

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    public void create(StorageEntity storageEntity) {
        entityManager.persist(storageEntity);
        logger.info("StorageEntity with id={} created in database", storageEntity.getId());

    }

    public List<StorageEntity> read() {
        logger.info("Getting all storageEntities from database");
        return entityManager.createNamedQuery("getAllStorages", StorageEntity.class).getResultList();
    }

    public Optional<StorageEntity> read(Integer id) {
        logger.info("Getting storageEntity with id={} from database", id);
        return Optional.ofNullable(entityManager.find(StorageEntity.class, id));
    }

    @Transactional
    public void delete(StorageEntity storageEntity) {
        logger.info("Deleting storageEntity with id={} from database", storageEntity.getId());
        entityManager.remove(entityManager.contains(storageEntity) ? storageEntity : entityManager.merge(storageEntity));
    }
}
