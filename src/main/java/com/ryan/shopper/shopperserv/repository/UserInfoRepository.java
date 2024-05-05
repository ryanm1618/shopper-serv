package com.ryan.shopper.shopperserv.repository;

import org.springframework.stereotype.Repository;

import com.ryan.shopper.shopperserv.entity.UserInfoEntity;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfoEntity, Integer>{
	Optional<UserInfoEntity> findByUserId(Integer id);
}
