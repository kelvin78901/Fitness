package com.fitness.appointment.mapper;

import com.fitness.appointment.pojo.MembershipCard;

public interface MembershipCardMapper {
    MembershipCard getMembershipCardByMemberId(int memberId);
    void updateMembershipCard(MembershipCard membershipCard);
}
