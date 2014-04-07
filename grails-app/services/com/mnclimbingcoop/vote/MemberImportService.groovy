package com.mnclimbingcoop.vote

class MemberImportService {

    void importMembers(InputStream input) {
        input.eachLine{ String line ->
            Member member = Member.fromCsv(line)
            member.save(failOnError: true)
        }
    }
}
