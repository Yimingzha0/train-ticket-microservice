package waitorder.repository;

import waitorder.entity.Money;
import org.springframework.data.repository.CrudRepository;

/**
 * @author fdse
 */
public interface AddMoneyRepository extends CrudRepository<Money,String> {
}
