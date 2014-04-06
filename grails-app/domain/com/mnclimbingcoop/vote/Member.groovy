package com.mnclimbingcoop.vote

import java.util.UUID

class Member {

    String memberNumber
    String name
    String voteHash = UUID.randomUUID().toString().replaceAll('-', '')
    Vote vote

    static constraints = {
        vote(nullable: true)
    }
}
