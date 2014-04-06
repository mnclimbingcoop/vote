class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

    "/"(controller: 'vote', action:'index')
    "500"(view:'/error')
    }
}
