package com.xcenter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.xcenter.entity.AdminMenu;

public interface AdminMenuRepository extends MongoRepository<AdminMenu, String>, CrudRepository<AdminMenu, String> {

}
