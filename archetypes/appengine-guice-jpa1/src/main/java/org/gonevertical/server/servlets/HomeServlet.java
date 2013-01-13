package org.gonevertical.server.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gonevertical.server.dao.SystemUserDao;
import org.gonevertical.server.domain.SystemUser;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class HomeServlet extends HttpServlet {
  private static Logger logger = Logger.getLogger(HomeServlet.class.getName());
  
  private SystemUserDao systemUserDao;

  @Inject
  public HomeServlet(SystemUserDao systemUserDao) {
    this.systemUserDao = systemUserDao;
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    UserService userService = UserServiceFactory.getUserService();

    String thisURL = request.getRequestURI();

    response.setContentType("text/html");
    if (request.getUserPrincipal() != null) {
      response.getWriter().println(
          "<p>Hello, " + request.getUserPrincipal().getName() + "!  You can <a href=\""
              + userService.createLogoutURL(thisURL) + "\">sign out</a>.</p>");
      createUser(userService.getCurrentUser());
    } else {
      response.getWriter()
          .println("<p>Please <a href=\"" + userService.createLoginURL(thisURL) + "\">sign in</a>.</p>");
    }
  }

  private void createUser(User user) {
    SystemUser systemUser = new SystemUser();
    systemUser.setGoogleId(user.getUserId());
    systemUser.setName(user.getNickname());
    systemUserDao.put(systemUser);
    
    logger.info("User created: systemUser=" + systemUser);
  }

}
