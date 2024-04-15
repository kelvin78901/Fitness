package com.fitness.appointment.service;

public interface MembershipCardService {
    boolean upgradeMembershipCard(int memberId, String membershipLevel);
}