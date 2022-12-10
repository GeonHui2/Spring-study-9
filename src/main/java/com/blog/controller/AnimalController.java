package com.blog.controller;

import com.blog.domain.AnimalType;
import com.blog.service.animal.AnimalService;
import com.blog.service.animal.AnimalServiceFinder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AnimalController {

// 1. component list 주입
// 2. map (key : beanName, value : service)
// 3. enum
    private final AnimalServiceFinder animalServiceFinder;

    private final Map<String, AnimalService> animalServices;

    @GetMapping("/sound1")
    public String sound1(@RequestParam String type) {
        AnimalService service = animalServiceFinder.find(type);

        return service.getSound();
    }

    @GetMapping("/sound2")
    public String sound2(@RequestParam String type) {
        AnimalService animalService = animalServices.get(type.toLowerCase() + "Service");

        return animalService.getSound();
    }

    @GetMapping("/sound3")
    public String sound3(@RequestParam String type) {
        AnimalType animalType = AnimalType.valueOf(type);
        AnimalService service = animalType.create();

        return service.getSound();
    }
}
