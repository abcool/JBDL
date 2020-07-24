package com.abcool.OAuth2DB.rest;

import com.abcool.OAuth2DB.dto.OAuth2DetailsRequestDTO;
import com.abcool.OAuth2DB.dto.OAuth2DetailsResponseDTO;

public interface IOAuth2Details {

	public OAuth2DetailsResponseDTO createClientDetails(OAuth2DetailsRequestDTO requestDTO);
}
