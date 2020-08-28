package com.example.multipledatasource;

import com.example.multipledatasource.bar.domain.Bar;
import com.example.multipledatasource.bar.repo.BarRepository;
import com.example.multipledatasource.foo.domain.Foo;
import com.example.multipledatasource.foo.repo.FooRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooBarController {

  private final FooRepository fooRepo;
  private final BarRepository barRepo;

  @Autowired
  FooBarController(FooRepository fooRepo, BarRepository barRepo) {
    this.fooRepo = fooRepo;
    this.barRepo = barRepo;
  }

  @RequestMapping("/foobar/{id}")
  public String fooBar(@PathVariable("id") Long id) {
    Optional<Foo> foo = fooRepo.findById(id);
    Optional<Bar> bar = barRepo.findById(id);

    return foo.get().getFoo() + " " + bar.get().getBar() + "!";
  }

  @PostMapping("/foobar")
  public void createNewFooBar(){
    Foo foo = new Foo("abc");
    fooRepo.save(foo);
    Bar bar = new Bar("def");
    barRepo.save(bar);
  }
  @GetMapping("/")
  public String test(){
    return "service is up";
  }

}
