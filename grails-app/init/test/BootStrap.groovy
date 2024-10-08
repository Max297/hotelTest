package test

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->

        fillDb()
    }
    def destroy = {
    }

    @Transactional
    void fillDb() {

        Country russia = new Country(countryName: 'Russia', countryCapital: 'Moscow');
        Country greece = new Country(countryName: 'Greece', countryCapital: 'Athens');
        Country egypt = new Country(countryName: 'Egypt', countryCapital: 'Cairo')
        Country turkey = new Country(countryName: 'Turkey', countryCapital: 'Ankara')

        Hotel hRussia1 = new Hotel(hotelName:"Ritz-Carlton", hotelCountry:russia, hotelStars:5, hotelUrl:"https://www.ritzcarlton.com/");
        Hotel hRussia2 = new Hotel(hotelName:"Marriott International", hotelCountry:russia, hotelStars:4, hotelUrl:"https://www.marriott.com/marriott/aboutmarriott.mi");
        Hotel hRussia3 = new Hotel(hotelName:"Hyatt", hotelCountry:russia, hotelStars:5, hotelUrl:"https://www.hyatt.com/");
        Hotel hRussia4 = new Hotel(hotelName:"Marins Park Hotel", hotelCountry:russia, hotelStars:3, hotelUrl:"https://marinshotels.ru/");
        Hotel hRussia5 = new Hotel(hotelName:"Marins Park Hostel", hotelCountry:russia, hotelStars:2);

        Hotel hGreece1 = new Hotel(hotelName:"Ritz-Carlton", hotelCountry:greece, hotelStars:5, hotelUrl:"https://www.ritzcarlton.com/");
        Hotel hGreece2 = new Hotel(hotelName:"Marriott International", hotelCountry:greece, hotelStars:4, hotelUrl:"https://www.marriott.com/marriott/aboutmarriott.mi");
        Hotel hEgypt1 = new Hotel(hotelName:"Hyatt", hotelCountry:egypt, hotelStars:5, hotelUrl:"https://www.hyatt.com/");
        Hotel hEgypt2 = new Hotel(hotelName:"Marins Park Hotel", hotelCountry:egypt, hotelStars:3, hotelUrl:"https://marinshotels.ru/");

        Hotel hTurkey1 = new Hotel(hotelName:"Ritz-Carlton", hotelCountry:turkey, hotelStars:5, hotelUrl:"https://www.ritzcarlton.com/");
        Hotel hTurkey2 = new Hotel(hotelName:"Marins Park Hotel", hotelCountry:turkey, hotelStars:3, hotelUrl:"https://marinshotels.ru/");

        russia.save(flush: true)
        greece.save(flush: true)
        egypt.save(flush: true)
        turkey.save(flush: true)

        hRussia1.save(flush:true)
        hRussia2.save(flush:true)
        hRussia3.save(flush:true)
        hRussia4.save(flush:true)
        hRussia5.save(flush:true)
        hGreece1.save(flush:true)
        hGreece2.save(flush:true)
        hEgypt1.save(flush:true)
        hEgypt2.save(flush:true)
        hTurkey1.save(flush:true)
        hTurkey2.save(flush:true)
    }
}
