package com.xcenter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xcenter.entity.XUser;

public interface XUserRepository extends MongoRepository<XUser, String> {

	XUser findByMobile(String mobile);
}
