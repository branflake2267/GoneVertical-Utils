package org.gonevertical.server.dao;

import com.google.inject.AbstractModule;

/**
 * bind DAOs here
 */
public class DaoModule extends AbstractModule {
  
  @Override
  protected void configure() {
    //bind(SystemUserDao.class).in(Singleton.class);
  }
  
}