package test

import grails.gorm.transactions.Transactional
import grails.rest.RestfulController

class HotelController {
    static responseFormats = ['json', 'xml']

    def hotelService
    def countryService



    def delete() {

        Long hotelId=params.long("id")
        def resMessage=hotelService.deleteHotel(hotelId)

        Map<String, Integer> result = new HashMap<>();
        result.put("message",resMessage)
        respond (result)
    }

    def add() {

        Long countryId=params.long("country")
        def name=params.name
        def stars=params.int("stars")
        def url=params.url

        Country foundCountry= countryService.findById(countryId)
        def resMessage=hotelService.addHotel(foundCountry,name,stars,url)

        Map<String, String> message = new HashMap<>();
        message.put("message",resMessage)
        respond (message)

    }
    def update() {
        Long hotelId=params.long("id")
        Long countryId=params.long("country")
        String name=params.name
        Integer stars=params.int("stars")
        String url=params.url



        Country foundCountry= countryService.findById(countryId)
        def resMessage=hotelService.updateHotel(hotelId,foundCountry,name,stars,url)

        Map<String, String> message = new HashMap<>();
        message.put("message",resMessage)
        respond (message)
    }
}
