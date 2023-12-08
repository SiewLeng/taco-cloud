package tacos.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.entities.TacoOrder;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}
