package com.mongocompetition.webscraper.dao;

import com.mongocompetition.webscraper.model.WebSite;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebSiteRepository extends MongoRepository<WebSite, String> {
}
