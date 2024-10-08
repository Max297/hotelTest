package test

class PagesController {

    def index() {
        def found=Country.getAll();


        respond([countries: found])
    }
    def search() {
        def name="%"+params.name+"%";
        def countryId =params.country;
        if (countryId!="all") {
            Country hotelCountry = Country.get(countryId);

            def cri = Hotel.createCriteria()
            def result = cri.list {
                like("hotelName", name)
                and {
                    eq("hotelCountry", hotelCountry)
                }
                order('hotelStars', 'desc')
                order('hotelName', 'asc')
            }
            respond([hotels:result]);
        }
        else{
            def cri = Hotel.createCriteria()
            def result = cri.list {
                like("hotelName", name)
                order('hotelStars', 'desc')
                order('hotelName', 'asc')
            }
            respond([hotels:result]);
        }



    }
    def hotelPage(){
        def found=Hotel.getAll();
        def countries=Country.getAll();



        respond([hotels: found, countries: countries, dbCall:Country])
    }
    def countryPage(){
        def found=Country.getAll();


        respond([countries: found])
    }
}
