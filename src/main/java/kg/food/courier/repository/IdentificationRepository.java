package kg.food.courier.repository;

import kg.food.courier.entity.Identification;

public interface IdentificationRepository extends CommonRepository<Identification> {
    Identification findByUsername(String username);
}
