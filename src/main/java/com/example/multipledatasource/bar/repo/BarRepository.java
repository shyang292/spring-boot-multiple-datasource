package com.example.multipledatasource.bar.repo;

import com.example.multipledatasource.bar.domain.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepository extends JpaRepository<Bar, Long> {

}
