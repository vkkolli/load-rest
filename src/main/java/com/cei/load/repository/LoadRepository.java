package com.cei.load.repository;


import java.util.List;
import com.cei.load.domain.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepository extends JpaRepository<Load, Long> {


	@Query(value = "select\r\n" + "	*\r\n" + "from\r\n" + "	load_mgmt.loads load\r\n" + "where\r\n"
			+ "	load.is_active = true\r\n"
			+ "	order by load.posted_date desc ", nativeQuery = true)
	List<Load> findAllActiveLoads();


}
