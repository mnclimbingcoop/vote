import com.mnclimbingcoop.vote.Member

class BootStrap {

    def init = { servletContext ->

        Member admin = Member.findByMemberNumber('00')
        if (!admin) {
            admin = new Member(name: 'Administrator', memberNumber: '00', admin:true).save(failOnError:true)
        }

        println "Administrator Access:"
        println "${admin.name} : ${admin.adminUrl}"
        println ""

        environments {
            development {

                println "================="
                println " Votable members "
                println "================="
                Member.list().each{ member ->
                    if (!member.admin) { println "${member.name} : ${member.votingUrl}" }
                }
            }
        }
    }

    def destroy = { }
}
