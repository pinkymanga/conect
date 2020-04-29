package com.finerioconnect.lite.services

import com.finerioconnect.lite.Application
import com.finerioconnect.lite.domain.UserApiData
import com.finerioconnect.lite.dtos.CreateCustomerDto

import io.micronaut.test.annotation.MicronautTest

import javax.inject.Inject

import spock.lang.Specification

@MicronautTest(application = Application.class)
class FinerioConnectApiServiceCreateCustomerSpec
    extends FinerioConnectLiteSpecification {

  @Inject
  FinerioConnectApiService finerioConnectApiService

  def 'method worked successfully'() {

    given:
      def props = getProps()
      def userApiData = new UserApiData(
        username: props.'finerio-connect.username',
        password: props.'finerio-connect.password',
        clientId: props.'finerio-connect.clientId',
        clientSecret: props.'finerio-connect.clientSecret'
      )
      def createCustomerDto = new CreateCustomerDto(
        name: UUID.randomUUID().toString()
      )
    when:
      def customerDto = finerioConnectApiService.createCustomer(
          userApiData, createCustomerDto )
    then:
      customerDto != null

  }

}
