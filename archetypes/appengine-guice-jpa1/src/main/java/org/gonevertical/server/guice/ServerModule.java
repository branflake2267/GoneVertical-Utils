package org.gonevertical.server.guice;

import org.gonevertical.server.servlets.ServletsModule;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * Main Server Guice Module
 */
public class ServerModule extends AbstractModule {
  
  @Override
  protected void configure() {
    install(new JpaPersistModule("transactions-optional"));
    install(new ServletsModule());

    bind(JpaInitilization.class).asEagerSingleton();
  }
  
}