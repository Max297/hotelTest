package test

import grails.gorm.transactions.Transactional

class BootStrap {
    def appService

    def init = { servletContext ->

        appService.fillDb()
    }
    def destroy = {
    }

}
