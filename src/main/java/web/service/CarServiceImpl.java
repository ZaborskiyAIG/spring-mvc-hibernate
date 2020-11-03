package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars = new ArrayList<>(Arrays.asList(new Car(1L, "model1", "series1"),
            new Car(2L, "model2", "series2"),
            new Car(3L, "model3", "series3"),
            new Car(4L, "model4", "series4"),
            new Car(5L, "model5", "series5")));

    @Override
    public List<Car> getCarsByCount(Integer count) {
        return new ArrayList<>(this.cars.subList(0, count));
    }
}
