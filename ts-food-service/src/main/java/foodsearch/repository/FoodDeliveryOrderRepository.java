package foodsearch.repository;

import foodsearch.entity.FoodDeliveryOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodDeliveryOrderRepository extends CrudRepository<FoodDeliveryOrder, String> {

    List<FoodDeliveryOrder> findByStationFoodStoreId(String stationFoodStoreId);

    @Override
    List<FoodDeliveryOrder> findAll();

}
