package com.exilant.myblog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.exilant.myblog.model.Country;

@Repository
public class CountryDaoImpl implements CountryDao {

	
	@Autowired
	private MongoTemplate mongo;
	@Override
	public String createCountry(Country country) {
		mongo.save(country, "country");
		return "save";
	}

	@Override
	public Country countryByCode(String code) {
	
		Query query=new Query();
		query.addCriteria(Criteria.where("countryCode").is(code));
		return mongo.findOne(query,Country.class,"country");
	}

	@Override
	public List<Country> allCountries() {
	
		return mongo.findAll(Country.class, "country");
	}



}
