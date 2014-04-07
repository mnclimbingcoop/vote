package com.mnclimbingcoop.vote

class Vote {

    static belongsTo = [ member: Member ]

    Boolean certified = false

    Boolean liz
    Boolean aaron
    Boolean jim
    Boolean jake
    Boolean logan

    String writeIn

    Date dateCreated
    Date lastUpdated

    String toCsvRecord() {
        return [ member.memberNumber, certified, liz, aaron, jim, jake, logan, writeIn ].join(',')
    }

}
