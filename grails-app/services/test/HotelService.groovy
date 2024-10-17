package test

import grails.gorm.transactions.Transactional

@Transactional
class HotelService {

    String deleteHotel(Long hotelId ) {
        def delCriteria= Hotel.createCriteria()
        def result =delCriteria.get {idEq(hotelId)};
        result.delete(flush: true)
        return "Deleted"

    }

    String addHotel(Country country, String hotelName, Integer stars, String url ) {
        if (url.trim()==""){
            url=null
        }
        Hotel newHotel = new Hotel(hotelCountry: country, hotelName: hotelName,hotelStars: stars ,hotelUrl:url) ;
        if (!newHotel.validate()) {
            return "validation failed"
        }
        else{
            newHotel.save(flush: true)
            return "saved"
        }

    }

    String updateHotel(Long hotelId,Country country, String name, Integer stars, String url ) {
        if (url.trim()==""){
            url=null
        }
        def findCriteria= Hotel.createCriteria()
        def result =findCriteria.get {idEq(hotelId)};

        result.setHotelCountry(country)
        result.setHotelName(name)
        result.setHotelStars(stars)
        result.setHotelUrl(url)

        if (!result.validate()) {
            return "validation failed"
        }
        else{
            result.save(flush: true)
            return "saved"
        }

    }
    List<Hotel> findByNameCountry(String name, Country country){
        def findCriteria= Hotel.createCriteria()
        name="%"+name+"%"

        def result=findCriteria.list {
            ilike("hotelName",name)
            and {
                eq("hotelCountry", country)
            }

            order('hotelStars','desc')
            order('hotelName','asc')

        }
        return result
    }
    List<Hotel> findByName(String name){
        def findCriteria= Hotel.createCriteria()
        name="%"+name+"%"

        def result=findCriteria.list {
            ilike("hotelName",name)

            order('hotelStars','desc')
            order('hotelName','asc')

        }
        return result
    }
    List <Hotel> findAll(Integer page){
        Integer pageLimit=3
        Integer limit=(page-1)*pageLimit
        def findCriteria= Hotel.createCriteria()
        def result =findCriteria.list {
            firstResult(limit)
            maxResults(pageLimit)
        }

        return result
    }
}
