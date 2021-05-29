package kg.food.courier.service.base;

import kg.food.courier.entity.BaseEntity;
import kg.food.courier.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseServiceImpl<Entity extends BaseEntity,
        Repository extends CommonRepository<Entity>>
        implements BaseService<Entity> {


    private final Repository userRepository;

    public BaseServiceImpl(Repository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Entity findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found!!"));
    }

    @Override
    public Entity create(Entity dto) {
        return userRepository.save(dto);

    }

    @Override
    public Entity update(Entity dto) {
        return userRepository.save(dto);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Entity> findByAll() {
        return userRepository.findAll();
    }
}
