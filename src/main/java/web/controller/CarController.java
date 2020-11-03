package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;


@Controller
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public String getCars(@RequestParam(defaultValue = "5") Integer count, Model model) {
        Integer maxSizeList = 5;

        if (count > maxSizeList) {
            model.addAttribute("cars", carService.getCarsByCount(maxSizeList));
        } else {
            model.addAttribute("cars", carService.getCarsByCount(count));
        }

        return "cars";
    }
}
