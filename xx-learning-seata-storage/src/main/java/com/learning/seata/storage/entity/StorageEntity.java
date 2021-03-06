package com.learning.seata.storage.entity;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "t_storage")
@Table(appliesTo = "t_storage")
public class StorageEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64)
    private String name;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
