package pl.javastart.springdataboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.springdataboot.model.Car;
import pl.javastart.springdataboot.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataBootApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx =
                SpringApplication.run(SpringDataBootApplication.class, args);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A4", "Audi", 49000.0));
        cars.add(new Car("A5", "Audi", 67000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opel", 29500.0));
        cars.add(new Car("A8", "Audi", 28000.0));
        cars.add(new Car("Corolla", "Toyota", 31000.0));
        cars.add(new Car("Vectra", "Opel", 29500.0));
        cars.add(new Car("Astra", "Opel", 29500.0));

        CarRepository carRepository = ctx.getBean(CarRepository.class);
        cars.forEach(carRepository::save);

        //Findall
        System.out.println("All toyota");
        List<Car> allByBrand = carRepository.findAllByBrand("Toyota");
        allByBrand.forEach(System.out::println);

        //find first by
        Car opel = carRepository.findFirstByBrand("Opel");
        System.out.println(opel);



        ctx.close();
    }

}
