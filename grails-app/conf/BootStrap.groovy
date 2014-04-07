import com.mnclimbingcoop.vote.Member

class BootStrap {

    def init = { servletContext ->
        String baseUrl = 'http://localhost:8080/mncc-vote'

        String adminUrl = baseUrl + '/admin/?id='
        Member admin = Member.findByMemberNumber('00')
        if (!admin) {
            admin = new Member(name: 'Administrator', memberNumber: '00', admin:true).save(failOnError:true)
        }

        println "Administrator Access:"
        println "${admin.name} : ${adminUrl}${admin.voteHash}"
        println ""

        environments {
            development {

                String voteUrl = baseUrl + '/?id='
                println "================="
                println " Votable members "
                println "================="
                Member.list().each{ member ->
                    if (!member.admin) { println "${member.name} : ${voteUrl}${member.voteHash}" }
                }
            }
        }
    }

    def destroy = { }
}
