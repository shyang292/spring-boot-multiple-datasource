package com.example.multipledatasource.foo.repo;

import com.example.multipledatasource.foo.domain.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository extends JpaRepository<Foo, Long> {
}
