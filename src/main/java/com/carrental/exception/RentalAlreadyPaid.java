package com.carrental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "The rental is already paid.")
public class RentalAlreadyPaid extends Exception{
}
