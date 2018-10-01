package com.exilant.myblog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.exilant.myblog.model.Country;
@Repository
public interface CountryDao {
 public String createCountry(Country country);
 public Country countryByCode(String code);
 public List<Country> allCountries();
}
