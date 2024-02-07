package com.workintech.s17D1.controller;

import com.workintech.s17D1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private Map<Long, Animal> animalMap= new HashMap<>();

    @PostMapping("/")
    public Animal addAnimal(@RequestBody Animal animal){
        animalMap.put(animal.getId(),animal);
        return animalMap.get(animal.getId());
    }

    @GetMapping("/")
    public List<Animal> allAnimal(){
       List<Animal> result=new ArrayList<>(animalMap.values().stream().toList());
       return result;

    }
    @GetMapping("/{id}")
    public Animal searchAnimalId(@PathVariable long id){
        return animalMap.get(id);

    }
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable long id,@RequestBody Animal animal){
        animalMap.replace(id,animal);
        return animalMap.get(id);
    }

    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable long id){
        Animal animal=animalMap.get(id);
        animalMap.remove(id);
        return animal;


    }
}
