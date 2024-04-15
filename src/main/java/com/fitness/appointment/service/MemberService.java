package com.fitness.appointment.service;

import com.fitness.appointment.pojo.MemberInfo;

// MemberService.java
public interface MemberService {
    MemberInfo getMemberById(int id);
    void upgradeMembership(MemberInfo memberInfo, String newLevel, double upgradePrice);
}
