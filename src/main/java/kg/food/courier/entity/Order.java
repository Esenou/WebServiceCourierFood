package kg.food.courier.entity;

import kg.food.courier.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name ="orders")
public class Order extends BaseEntity{

    @Column(name = "delivery_address",nullable = false)
    private String delivery_address;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "status")
    private OrderStatus status = OrderStatus.AWAITING;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client")
    private User client;

}
