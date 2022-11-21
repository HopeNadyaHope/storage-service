package com.epam.microservices.model;

import javax.validation.constraints.NotBlank;

public class StorageModel {

    private int id;

    @NotBlank(message = "StorageType can't be empty")
    private String storageType;

    @NotBlank(message = "Bucket can't be empty")
    private String bucket;

    @NotBlank(message = "Path can't be empty")
    private String path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
