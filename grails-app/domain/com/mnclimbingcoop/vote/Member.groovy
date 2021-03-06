package com.mnclimbingcoop.vote

import java.util.UUID
import org.joda.time.LocalDate

class Member {

    static final String BASE_URL = 'http://vote.mnclimbingcoop.com'

    static final String CSV_HEADER = 'member_id,full_name,email,member_since,vote_key,voting_url,voted\n'

    String memberNumber
    String name
    String email
    LocalDate memberSince
    String voteHash = UUID.randomUUID().toString().replaceAll('-', '')
    Boolean admin = false
    Vote vote

    static constraints = {
        vote(nullable: true)
        memberSince(nullable: true)
        memberNumber(unique: true)
        email(nullable:true)
    }

    Date getVoted() { return vote?.dateCreated }

    String toCsvRecord() {
        String votingUrl = BASE_URL + '/ballot/' + voteHash
        return [ memberNumber, name, email, memberSince, voteHash, votingUrl, voted ].join(',')
    }

    String getVotingUrl() {
        if (admin) { return null }
        return BASE_URL + '/?id=' + voteHash
    }

    String getAdminUrl() {
        if (admin) { return BASE_URL + '/admin/?id=' + voteHash }
    }

    String toString() {
        println "member[${memberNumber}]: ${name}, since ${memberSince}"
    }

    static final String CSV_FORMAT = 'member_id, first_name, middle_name, last_name, suffix, email, member_since'

    static Member fromCsv(String line) {
        List<String> parts = line.split(',')
        if (parts.size() == 7) {

            String memberId    = parts[0]
            String firstName   = parts[1]
            String middleName  = parts[2]
            String lastName    = parts[3]
            String suffix      = parts[4]
            String email       = parts[5]
            String memberStart = parts[6]

            String name = (firstName + ' ' + middleName + ' ' + lastName + ' ' + suffix).replaceAll('  ', ' ')
            println "parsing date from '${memberStart}' for ${name}"
            LocalDate memberSince = new LocalDate(memberStart)

            Member member = new Member(
                memberNumber: memberId,
                name: (firstName + ' ' + middleName + ' ' + lastName + ' ' + suffix).replaceAll('  ', ' '),
                email: email,
                memberSince: new LocalDate(memberStart)
            )

        } else {
            throw new IllegalArgumentException("CSV import must contain 7 columns, expected: ${CSV_FORMAT}")
        }
    }
}
