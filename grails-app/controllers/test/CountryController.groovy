package test

import grails.gorm.transactions.Transactional
import grails.rest.RestfulController

class CountryController extends RestfulController{

    static responseFormats = ['json', 'xml']
    CountryController(){
        super(Country);
    }

    def get(Long id){
        respond Country.get(id);
    }

    @Transactional
    def delete() {
        def country = Country.get(params.id)


        country.delete(flush: true)

        Map<String, Integer> result = new HashMap<>();
        result.put("message","works")
        respond (result)
    }

    @Transactional
    def add() {
        Country created = new Country(countryName: params.name, countryCapital: params.capital);
        def result=created.save(flush: true)



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
        Country created = Country.get(params.id)

        created.setProperty("countryName", params.name)
        created.setProperty("countryCapital", params.capital)

        def result=created.save(flush: true)


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
