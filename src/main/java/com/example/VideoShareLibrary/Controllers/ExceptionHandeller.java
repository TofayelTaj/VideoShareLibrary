package com.example.VideoShareLibrary.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandeller {

    @ExceptionHandler(value = Exception.class)
    public String exceptionAndError(Model model){
        model.addAttribute("errorMsg", "Something went wrong. \n Please Try Again");
        return "error";
    }


}
