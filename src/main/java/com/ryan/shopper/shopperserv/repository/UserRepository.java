package com.ryan.shopper.shopperserv.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.shopper.shopperserv.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{
	Optional<UserEntity> findByUserNameAndPassword(String userName, String password);
	Optional<UserEntity> findByUserName(String userName);
}
