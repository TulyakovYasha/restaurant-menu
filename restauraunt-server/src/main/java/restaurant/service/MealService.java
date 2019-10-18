package restaurant.service;

import api.dto.MealDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurant.util.MealUtil;
import restaurant.dao.RestaurantMenuRepository;
import restaurant.model.MealEntity;


@Service
public class MealService {

    @Autowired
    RestaurantMenuRepository repository;

    @Transactional
    public MealDTO save(MealDTO meal) {
        MealEntity createdMealEntity;
        if (meal.isExist()) {
            createdMealEntity = repository.save(MealUtil.convertToEntityWithUuid(meal));
            return get(createdMealEntity.getUuid());
        } else {
            createdMealEntity = repository.save(MealUtil.convertToEntity(meal));
        }
        return get( createdMealEntity.getUuid());
    }

    @Transactional
    public boolean delete(String uuid) {
        return repository.deleteByUuid(uuid) != 0;
    }

    @Transactional(readOnly = true)
    public MealDTO get(String uuid) {
        return MealUtil.convertToDTO(repository.getByUuid(uuid));
    }

    public MealDTO getByUuid(String uuid) {
        return MealUtil.convertToDTO(repository.getByUuid(uuid));
    }

}
