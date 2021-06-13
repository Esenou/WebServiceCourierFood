package kg.food.courier.service;

import kg.food.courier.entity.Client;
import kg.food.courier.entity.Identification;
import kg.food.courier.service.base.BaseService;

public interface IdentificationService extends BaseService<Identification> {
    Identification findByUsername(String username);
}
