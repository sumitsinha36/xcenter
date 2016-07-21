package com.xcenter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.xcenter.entity.Xuser;

public interface XUserRepository extends MongoRepository<Xuser, String>, CrudRepository<Xuser, String> {

	Xuser findByMobile(String mobile);
}
