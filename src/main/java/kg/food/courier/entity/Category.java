package kg.food.courier.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category extends BaseEntity {
    @Column(name = "name",nullable = false)
    private String name;
}
