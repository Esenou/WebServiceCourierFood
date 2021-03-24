package kg.food.courier.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "basket")
public class Basket extends BaseEntity{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="id_order")
    private Order order;
}
