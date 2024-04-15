package com.fitness.appointment.service;

public interface EmailService {
    void sendUpgradeConfirmationEmail(String recipientEmail, String membershipLevel);
}
