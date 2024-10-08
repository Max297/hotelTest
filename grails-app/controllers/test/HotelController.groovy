package test

import grails.gorm.transactions.Transactional
import grails.rest.RestfulController

class HotelController extends RestfulController{
    static responseFormats = ['json', 'xml']

    HotelController(){
        super(Hotel);
    }


    def findHotel() {
        def name="%"+params.name+"%";
        def countryId =params.country;

        Country hotelCountry=Country.get(countryId);


        respond Hotel.findAllByHotelNameIlikeAndHotelCountry("%${name}%", hotelCountry)



    }
    @Transactional
    def delete() {
        def hotel = Hotel.get(params.id)


        hotel.delete(flush: true)

        Map<String, Integer> result = new HashMap<>();
        result.put("message","works")
        respond (result)
    }

    @Transactional
    def add() {
        def country = Country.get(params.country)

        def url=params.url
        if (url.trim()==""){
            url=null
        }
        Hotel created = new Hotel(hotelName:params.name, hotelCountry:country, hotelStars:params.stars, hotelUrl:url);

        def result= created.save(flush: true)


        Map<String, String> message = new HashMap<>();
        if (result!=null){

            message.put("message","saved")

        }
        else{

            message.put("message","validation failed")

        }
        respond (message)



    }
    @Transactional
    def update() {
        Hotel created = Hotel.get(params.id)
        def country = Country.get(params.country)

        def url=params.url
        if (url.trim()==""){
            url=null
        }

        created.setProperty("hotelName", params.name)
        created.setProperty("hotelCountry", country)
        created.setProperty("hotelStars", Integer.parseInt(params.stars))
        created.setProperty("hotelUrl",url)



        def result= created.save(flush: true,failOnError: true )


        Map<String, String> message = new HashMap<>();
        if (result!=null){

            message.put("message","saved")

        }
        else{

            message.put("message","validation failed")

        }
        respond (message)
    }
}
