package kg.food.courier.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "unit")
public class Unit extends BaseEntity{
    @Column(name = "name", nullable = false)
    private String name;
}
