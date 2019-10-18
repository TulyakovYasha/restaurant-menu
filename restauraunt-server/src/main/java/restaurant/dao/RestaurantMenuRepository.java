package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant.model.MealEntity;


@Repository
public interface RestaurantMenuRepository extends JpaRepository<MealEntity, String> {

    int deleteByUuid(String uuid);

    MealEntity getByUuid(String uuid);

}
