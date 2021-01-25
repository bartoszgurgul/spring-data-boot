package pl.javastart.springdataboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.springdataboot.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
}
