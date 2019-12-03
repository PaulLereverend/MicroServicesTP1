package com.paullereverend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Utilisateur not found")
public class UtilisateurNotFoundException extends RuntimeException {
}
