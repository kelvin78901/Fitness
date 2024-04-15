package com.fitness.appointment.service.impl;

import com.fitness.appointment.mapper.MemberInfoMapper;
import com.fitness.appointment.mapper.MembershipCardMapper;
import com.fitness.appointment.pojo.MemberInfo;
import com.fitness.appointment.pojo.MembershipCard;
import com.fitness.appointment.service.EmailService;
import com.fitness.appointment.service.MembershipCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembershipCardServiceImpl implements MembershipCardService {
    @Autowired
    private MembershipCardMapper membershipCardMapper = new MembershipCardMapper() {
        @Override
        public MembershipCard getMembershipCardByMemberId(int memberId) {
            return null;
        }

        @Override
        public void updateMembershipCard(MembershipCard membershipCard) {

        }
    };
    @Autowired
    private MemberInfoMapper memberInfoMapper = new MemberInfoMapper() {
        @Override
        public MemberInfo getMemberInfoById(int memberId) {
            return null;
        }
    };
    @Autowired
    private EmailService emailService = new EmailServiceImpl();

    @Override
    public boolean upgradeMembershipCard(int memberId, String membershipLevel) {
        // Retrieve member info
        MemberInfo memberInfo = memberInfoMapper.getMemberInfoById(memberId);
        if (memberInfo == null) {
            return false; // Member does not exist
        }

        // Retrieve membership card info
        MembershipCard membershipCard = membershipCardMapper.getMembershipCardByMemberId(memberId);
        if (membershipCard == null) {
            return false; // Membership card not found
        }

        // Check balance and upgrade membership level
        if (membershipCard.getCardBalance() >= getUpgradePrice(membershipLevel)) {
            // Sufficient balance, perform upgrade
            membershipCard.setCardLevel(membershipLevel);
            membershipCard.setCardBalance(membershipCard.getCardBalance() - getUpgradePrice(membershipLevel));
            membershipCardMapper.updateMembershipCard(membershipCard);

            // Send confirmation email
            emailService.sendUpgradeConfirmationEmail(memberInfo.getEmail(), membershipLevel);

            return true; // Upgrade successful
        } else {
            return false; // Insufficient balance
        }
    }

    private int getUpgradePrice(String membershipLevel) {
        // Implement logic to get upgrade price based on membership level
        // For example, return different prices for Silver, Gold, and Diamond levels
        return 0;
    }
}