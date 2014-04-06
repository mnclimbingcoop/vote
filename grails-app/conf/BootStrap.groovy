import com.mnclimbingcoop.vote.Member

class BootStrap {

    def init = { servletContext ->
        environments {
            development {
                new Member(name: 'Micah', memberNumber: '01').save(failOnError: true)
                new Member(name: 'Aaron', memberNumber: '11').save(failOnError: true)
                new Member(name: 'Jake',  memberNumber: '32').save(failOnError: true)
                new Member(name: 'Pi',    memberNumber: '42').save(failOnError: true)

                String baseUrl = 'http://localhost:8080/mncc-vote/?id='
                println "Votable members:"
                println "================"
                Member.list().each{
                    println "${it.name} : ${baseUrl}${it.voteHash}"
                }
            }
        }
    }
    def destroy = {
        println "Votes:"
        println "================"
        Vote.list().each{ vote ->
            println "Voter: ${vote.member.name}"
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
