package com.fitness.appointment.service.impl;

import com.fitness.appointment.mapper.MemberInfoMapper;
import com.fitness.appointment.pojo.MemberInfo;
import com.fitness.appointment.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// MemberServiceImpl.java
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberInfoMapper memberInfoMapper;

    @Override
    public MemberInfo getMemberById(int id) {
        return memberInfoMapper.getMemberById(id);
    }

    @Override
    public void upgradeMembership(MemberInfo memberInfo, String newLevel, double upgradePrice) {
        // Implement upgrade logic here
        // Check if the balance is sufficient, update member's card level and balance, etc.
        // You can also interact with other services or repositories if needed
    }
}
