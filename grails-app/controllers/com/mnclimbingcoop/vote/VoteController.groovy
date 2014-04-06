package com.mnclimbingcoop.vote

class VoteController {

    def index() {
        Member member = Member.findByVoteHash(params.id)
        if (!member) {
            render "Sorry."
            return
        }

        Seats seats = new Seats()

        Map model = [ seats: seats, member: member ]

        return model
    }

}
