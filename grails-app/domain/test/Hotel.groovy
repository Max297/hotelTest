package test

class Hotel implements Serializable {

    String hotelName;
    Country hotelCountry;
    Integer hotelStars;
    String hotelUrl;

    static constraints = {
        hotelName nullable: false, blank: false, maxSize: 255,unique: ['hotelCountry']
        hotelCountry nullable: false, blank: false, maxSize: 255
        hotelStars nullable: false, blank: false, min:1, max:5
        hotelUrl nullable: true, blank: true, validator: { val, obj ->
            if ( val !=null && (!val.startsWith("http://") && !val.startsWith("https://"))) {
                return ['myString.invalid']
            }
        }
    }

}
