package hiber.service;

import hiber.model.Car;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CarService {
    void add(Car car);
}
