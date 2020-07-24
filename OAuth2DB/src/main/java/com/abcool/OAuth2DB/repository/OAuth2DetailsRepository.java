package com.abcool.OAuth2DB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcool.OAuth2DB.entity.OAuthClientDetails;
public interface OAuth2DetailsRepository extends JpaRepository<OAuthClientDetails, String>{

}
