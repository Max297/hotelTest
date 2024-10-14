package test

import grails.gorm.transactions.Transactional
import org.grails.datastore.mapping.query.Query.In

@Transactional
class CountryService {

    String deleteCountry(Long countryId ) {
        def delCriteria= Country.createCriteria()
        def result =delCriteria.get {idEq(countryId)};
        result.delete(flush: true)
        return "Deleted"

    }

    String addCountry(String name, String capital ) {
        Country newCountry = new Country(countryName: name, countryCapital: capital);
        if (!newCountry.validate()) {
            return "validation failed"
        }
        else{
            newCountry.save(flush: true)
            return "saved"
        }
    }

    String updateCountry(Long countryId, String name, String capital ) {
        def findCriteria= Country.createCriteria()
        def result =findCriteria.get {idEq(countryId)};
        result.setCountryName(name)
        result.setCountryCapital(capital)
        if (!newCountry.validate()) {
            return "validation failed"
        }
        else{
            newCountry.save(flush: true)
            return "saved"
        }

    }

    List <Country> findAll(){
        def findCriteria= Country.createCriteria()
        def result =findCriteria.list {}

        return result
    }

    Country findById(Long countryId){
        //countryId=1
        def findCriteria= Country.createCriteria()
        def result =findCriteria.get {idEq(countryId)};

        return result

    }


}
