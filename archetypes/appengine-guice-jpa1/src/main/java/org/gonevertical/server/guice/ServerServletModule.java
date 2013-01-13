package org.gonevertical.server.guice;

import org.gonevertical.server.servlets.HomeServlet;

import com.google.inject.servlet.ServletModule;

/**
 * This starts in web.xml. All requests are intercepted and sent here.
 */
public class ServerServletModule extends ServletModule {
  
  @Override
  public void configureServlets() {
    serve("/*").with(HomeServlet.class);
  }
  
}