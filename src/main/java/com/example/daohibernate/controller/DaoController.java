package com.example.daohibernate.controller;

import com.example.daohibernate.entity.PersonEntity;
import com.example.daohibernate.repository.DaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class DaoController {

    private final DaoRepository daoRepository;

    public DaoController(DaoRepository daoRepository) {
        this.daoRepository = daoRepository;
    }

    @GetMapping("/by-city")
    public ResponseEntity<List<PersonEntity>> getPersons(@RequestParam String city) {
        List<PersonEntity> names = daoRepository.getPersonsByCity(city);
        return ResponseEntity.ok().body(names);
    }

}
