package com.cei.load.repository;


import java.util.List;
import com.cei.load.domain.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepository extends JpaRepository<Load, Long> {

	public List<Load> findAll();


}
