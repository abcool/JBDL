package com.abcool.OAuth2DB.service;

import com.abcool.OAuth2DB.dto.OAuth2DetailsRequestDTO;
import com.abcool.OAuth2DB.dto.OAuth2DetailsResponseDTO;

public interface IOAuth2Details {

	/**
	 * @author Arvind Bakshi
	 * @param OAuth2DetailsRequestDTO
	 * @apiNote This method inserts a record into oauth_client_details table
	 * @return OAuth2DetailsResponseDTO object
	 */
	public OAuth2DetailsResponseDTO createClientDetails(OAuth2DetailsRequestDTO requestDTO);
}
