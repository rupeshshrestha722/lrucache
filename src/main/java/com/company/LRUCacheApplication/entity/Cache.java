package com.company.LRUCacheApplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name="lrucaches")
public class Cache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

    @Column(name = "access_order")
    private int accessOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getAccessOrder() {
        return accessOrder;
    }

    public void setAccessOrder(int accessOrder) {
        this.accessOrder = accessOrder;
    }
}
