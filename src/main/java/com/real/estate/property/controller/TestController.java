package com.real.estate.property.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.real.estate.property.constants.AppConstants;
import com.real.estate.property.enums.SuccessResponseEnum;
import com.real.estate.property.responsehandler.ResponseHandler;

import jakarta.annotation.security.RolesAllowed;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

	@GetMapping("/test")
	@RolesAllowed({ AppConstants.ROLE_ADMIN })
	public ResponseEntity<?> testingEndpoint(HttpServletRequest request, @AuthenticationPrincipal Jwt jwt)
			throws Exception {
		log.info("Testing Controller Executed only when user have access to Admin role on keycloak.");
		return ResponseHandler.generateResponse(SuccessResponseEnum.SUCCESS_GET.getResponseMessage(), request,
				SuccessResponseEnum.SUCCESS_GET.getResponseCode(), null);
	}

}
