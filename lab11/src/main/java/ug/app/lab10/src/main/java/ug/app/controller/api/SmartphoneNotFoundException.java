package ug.app.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such smartphone exists")
public class SmartphoneNotFoundException extends RuntimeException{
}
