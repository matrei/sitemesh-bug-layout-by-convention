package com.example
import grails.plugin.geb.ContainerGebSpec
import grails.testing.mixin.integration.Integration

/**
 * See https://docs.grails.org/latest/guide/testing.html#functionalTesting and https://www.gebish.org/manual/current/
 * for more instructions on how to write functional tests with Grails and Geb.
 */
@Integration
class SitemeshLayoutByConventionSpec extends ContainerGebSpec {

    void 'should display the correct title on the home page'() {
        when: 'visiting the home page'
            go '/'

        then: 'the page title is correct'
            title == 'Welcome to Grails'
    }

    void 'test layout by convention'() {
        when:
        go '/layoutByConvention'

        then:
        title == 'Convention Layout'
    }

    void 'test layout specified in controller property'() {
        when:
        go '/layoutSpecifiedByProperty'

        then:
        title == 'Foo Layout'

    }

    void 'test layout specified in controller property applied to a GSP that does not contain a root html tag'() {
        when:
        go '/layoutSpecifiedByProperty/snippetView'

        then:
        title  == 'Foo Layout'
        $().text().contains 'this is some content'
    }
}
