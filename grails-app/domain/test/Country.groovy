package test

class Country {
    String countryName;
    String countryCapital;

    static constraints = {
        countryName nullable: false, blank: false, maxSize: 255,unique: true
        countryCapital nullable: false, blank: false, maxSize: 128
    }
    static hasMany = [hotel: Hotel]
    static mapping = {
        hotel cascade: 'all-delete-orphan'
    }
}
