package com.cei.load.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cei.load.domain.Zipcode;

/**
 * The Interface ZipcodeRepository.
 */
@Repository
public interface ZipcodeRepository extends JpaRepository<Zipcode, Long> {

	/**
	 * Search city state zips.
	 *
	 * @param criteria the criteria
	 * @return the list
	 */
	@Query(value = "SELECT a.city || ', ' || a.state_abbr || ', ' || a.zipcode FROM logisol.us_zip a WHERE LOWER(a.city) like :criteria ORDER BY city", nativeQuery = true)
	@Cacheable({ "cityStateZipBySearchTerm" })
	List<String> searchCityStateZips(@Param("criteria") String criteria);

	/**
	 * Search city state zip by zip code and country code.
	 *
	 * @param paramString1 the param string 1
	 * @param paramString2 the param string 2
	 * @return the list
	 */
	@Query(value = "SELECT a.city || ', ' || a.state_abbr || ', ' || a.zipcode FROM logisol.us_zip a WHERE a.country_abbr = :countryCode AND a.zipcode LIKE :zipCode", nativeQuery = true)
	@Cacheable({ "cityStateZipByZipCodeAndCountryCode" })
	List<String> searchCityStateZipByZipCodeAndCountryCode(@Param("zipCode") String paramString1,
			@Param("countryCode") String paramString2);

}
