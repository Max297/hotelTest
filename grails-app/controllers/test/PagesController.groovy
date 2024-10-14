package test


class PagesController {
    def countryService;
    def hotelService;

    def index() {
        def found= countryService.findAll()


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
        def found=hotelService.findAll();

        def countries= countryService.findAll()

        respond([hotels: found, countries: countries, dbCall:Country])
    }
    def countryPage(){
        def found= countryService.findAll()


        respond([countries: found])
    }
}
