package com.finerioconnect.lite.domain

import grails.gorm.annotation.Entity
import io.micronaut.security.authentication.providers.UserState
import org.grails.datastore.gorm.GormEntity

@Entity 
class User implements GormEntity<User>, UserState { 

  String username
  String password
  boolean enabled = true
  boolean accountExpired = false
  boolean accountLocked = false
  boolean passwordExpired = false
  Date dateCreated
  Date lastUpdated

  static constraints = { 
    username nullable: false, blank: false, unique: true
    password nullable: false, blank: false, password: true
  }

  static mapping = { 
    table 'user'
    password column: '`password`'
  }

}