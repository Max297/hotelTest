package test


class PagesController {
    def countryService;
    def hotelService;

    def index() {
        def found= countryService.getAllForList()


        respond([countries: found])
    }
    def search() {
        String name=params.name;
        if (params.country=="all"){
            def result=hotelService.findByName(name)
            respond([hotels:result]);
        }
        else{
            Long countryId =params.long("country");

            Country hotelCountry = countryService.findById(countryId);
            def result=hotelService.findByNameCountry(name, hotelCountry)
            respond([hotels:result]);
        }





    }
    def hotelPage(){
        Integer page=1
        if (params.containsKey("page")){
            page=params.page as Integer;
        }
        def found=hotelService.findAll(page);

        def countries= countryService.getAllForList()

        respond([hotels: found, countries: countries, dbCall:Country])
    }
    def countryPage(){
        Integer page=1
        if (params.containsKey("page")){
            page=params.page as Integer;
        }

        def found= countryService.findAll(page)


        respond([countries: found])
    }
}
