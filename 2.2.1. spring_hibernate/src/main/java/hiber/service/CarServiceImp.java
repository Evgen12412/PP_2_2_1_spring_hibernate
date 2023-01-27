package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImp implements CarService {


    private CarDao carDao;

    @Autowired
    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }
    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }
    @Transactional(readOnly = true)
    @Override
    public User getUserAndCar(String model, int series) {
        return carDao.getUserAndCar(model, series);
    }
}
