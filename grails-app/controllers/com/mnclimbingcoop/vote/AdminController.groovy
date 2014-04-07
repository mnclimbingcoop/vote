package com.mnclimbingcoop.vote

class AdminController {

    def memberImportService

    def beforeInterceptor = [ action: this.&auth ]

    def index() {
        [ voteHash: params.id ]
    }

    def votes() {
        export('votes') { out ->
            out << "member_id, certified, certified, liz, aaron, jim, jake, logan, writeIn\n"
            Votes.list().each{ v -> out << v.toCsvRecord() + "\n" }
        }
    }

    def members() {
        exportMembers()
    }

    def upload() {
        def multiPartFile = request.getFile('members')
        if (multiPartFile.empty) {
            flash.message = 'file cannot be empty'
            render(view: 'index', voteHash: params.id)
            return
        }

        memberImportService.importMembers(multiPartFile.inputStream)

        //exportMembers()
        response.sendError(200, 'Done')
    }

    private exportMembers() {
        export('members') { out ->
            out << "member_id,full_name,email,member_since,vote_key,voting_url,voted\n"
            Member.list().each{ m -> 
                if (!m.admin && m.memberSince) { out << m.toCsvRecord() + "\n" }
            }
        }
    }

    private boolean auth() {
        Member member = Member.findByVoteHash(params.id)
        if (member?.admin) {
            return true
        } else {
            render "Sorry."
            return false
        }
    }

    private export(String fileName, Closure cls) {
        response.setHeader("Content-disposition", "attachment; filename=${fileName}.csv")
        response.contentType = "application/vnd.ms-excel"
        def out = response.outputStream
        cls(out)
        out.flush()
        out.close()
    }

}

