package com.fitness.appointment.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembershipCard {
    private int cardId;
    private int memberId;
    private String cardLevel;
    private int cardBalance;
}
