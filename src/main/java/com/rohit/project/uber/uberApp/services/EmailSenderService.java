package com.rohit.project.uber.uberApp.services;

public interface EmailSenderService {

    public void sendEmail(String toEmail , String subject , String body);
    // Structure of the Email

    public void sendEmail(String[] toEmail , String subject , String body);

}
