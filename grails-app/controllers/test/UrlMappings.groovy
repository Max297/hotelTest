package test

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/api/country"(resources: 'Country')
        "/api/hotel"(resources: 'Hotel')


        "/"(controller: "pages")
        "/hotelPage"(controller: "pages", action: 'hotelPage')
        "/countryPage"(controller: "pages", action: 'countryPage')

        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
