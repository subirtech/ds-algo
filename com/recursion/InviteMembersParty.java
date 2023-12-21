package com.recursion;

/**
 * Find the number of ways in which you can invite n people to your party, single or in pairs
 */
public class InviteMembersParty {

    public static int inviteGuest(int n) {

        if (n <= 1) return 1;
        //Single
        int singleWay = inviteGuest(n - 1);

        //paired
        int pairedWay = (n - 1) * inviteGuest(n - 2);

        return singleWay + pairedWay;
    }

    public static void main(String[] args) {
        int guestCount=3;
        System.out.println(inviteGuest(guestCount));
    }
}
