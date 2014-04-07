package com.mnclimbingcoop.vote

class VoteController {

    def index() {
        Member member = Member.findByVoteHash(params.id)
        Seats seats = new Seats()

        Map model = [ seats: seats, member: member ]

        printVotes()

        return model
    }

    def vote() {
        Member member = Member.findByVoteHash(params.voteHash)
        if (!member) {
            render "Sorry."
            return
        }
        Vote vote = new Vote(params)
        if (vote.certified) {
            vote.member = member
            member.vote = vote
            member.save(failOnError:true)

            println "New Vote: ${vote.member.name}"
            println " * certified: ${vote.certified}"
            println " * liz: ${vote.liz}"
            println " * aaron: ${vote.aaron}"
            println " * jim: ${vote.jim}"
            println " * jake: ${vote.jake}"
            println " * logan: ${vote.logan}"
            println " * writeIn: ${vote.writeIn}"
        } else {
            println "submission w/o certification"
            vote.discard()
        }

        redirect(action:'index', id: member.voteHash)
    }

    private void printVotes() {
        println "Votes:"
        println "================"
        Vote.list().each{ vote ->
            println "Voter: ${vote.member?.name}"
            println " * certified: ${vote.certified}"
            println " * liz: ${vote.liz}"
            println " * aaron: ${vote.aaron}"
            println " * jim: ${vote.jim}"
            println " * jake: ${vote.jake}"
            println " * logan: ${vote.logan}"
            println " * writeIn: ${vote.writeIn}"
        }
    }
}
