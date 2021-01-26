package pl.javastart.springdataboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.springdataboot.model.Car;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    //implementacja interfejsu jparepository i calego Spring Data
    // pozawala na konstruowaniu nazwy metody a spirng zamie sie reszta xD
    // tylko my muslimy nad buznesem a oni robia reszte

    // ---
    // konstrukcje zaczynamy od słów get, read, find, query
    // i tak wszysyc uzywaja find

    // kolejne słowo to By << który rozpoczyna nam ograniczenia

    // -- OGRANICZENIE PO POLACH
    // najlepsze jest to ze Spring sobie to sprawdza i mowi na biezaco czy to ma sens
    // SELECT * FROM CAR c WHERE c.BRAND = '';
    List<Car> findAllByBrand(String brand);

    // -- ORANICZENIE LICZBY ZWROCONYCH ELEMENTÓW
    Car findFirstByBrand(String brand); // tylko przerwszy
    List<Car> findTop5ByBrand(String brand); // piersze 3

    // -- OPERATORY LOGICZNE
    List<Car> findFirst5ByBrandAndPrice(String brand, Double price);

    // -- DOPASOWANIA DO WZORCA
    List<Car> findAllByPriceLessThan(Double price);
    List<Car> findAllByPriceGreaterThanEqual(Double price);
    List<Car> findAllByPriceBetween(Double priceLess, Double priceGreat);

    // -- SORTOWANIE
    List<Car> findAllByPriceOrderByIdAsc(Double price);

    // -- NULLe / TRUE FALSE
    List<Car> findAllByBrandNotNull();
    List<Car> findByNameIn(Collection<String> name);

}
