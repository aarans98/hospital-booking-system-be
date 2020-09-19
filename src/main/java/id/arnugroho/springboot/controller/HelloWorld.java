package id.arnugroho.springboot.controller;


import id.arnugroho.springboot.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// fungsi buat apa
@RestController
public class HelloWorld {
    // fungsi buat apa
    @GetMapping("/person")
    public List<Person> getPerson(){
        Person p = new Person();
        p.setNama("akbar");
        p.setAlamat("bogor");
        Person p1 = new Person();
        p1.setNama("nugroho");
        p1.setAlamat("jakarta");

        List<Person> personList = new ArrayList<>();
        personList.add(p);
        personList.add(p1);
        return personList;
    }
}
