package test

import grails.gorm.transactions.Transactional
import grails.rest.RestfulController

class CountryController {

    static responseFormats = ['json', 'xml']
    def countryService


    def delete() {
        Long countryId = params.long("id")

        String resMessage=countryService.deleteCountry(countryId)


        Map<String, Integer> result = new HashMap<>();
        result.put("message",resMessage)
        respond (result)
    }

    def add() {


        def name=params.name

        def capital=params.capital

        def resMessage=countryService.addCountry(name,capital)

        Map<String, String> message = new HashMap<>();
        message.put("message",resMessage)
        respond (message)


    }

    def update() {
        Long countryId = params.long("id")
        String name=params.name
        String capital=params.capital

        def resMessage=countryService.updateCountry(countryId,name, capital )

        Map<String, String> message = new HashMap<>();
        message.put("message",resMessage)
        respond (message)
    }
}
