package com.jeremy.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "holidays")
public class Holiday extends BaseEntity {

    @Id
    @Column(name = "holidays_day")
    private String day;
    private String reason;
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type{
        FESTIVAL, FEDERAL, CULTURAL, RELIGIOUS
    }
}
