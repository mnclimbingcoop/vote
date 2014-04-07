class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

    "/"(controller: 'vote', action:'index')
    "/ballot/$id?"(controller: 'vote', action:'index')
    "/vote"(controller: 'vote', action:'vote')
    "500"(view:'/error')
    }
}
