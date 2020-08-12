package com.swann.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class DateTime {

    private Date created_date;
    private Date update_date;

    @PrePersist
    protected void onCreate() {
        this.created_date = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.update_date = new Date();
    }
}
