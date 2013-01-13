package org.gonevertical.server.dao;

import javax.persistence.Query;

import org.gonevertical.server.domain.SystemUser;

public class SystemUserDao extends BaseDao<SystemUser> {

  public SystemUserDao() {
    super(SystemUser.class);
  }

  public SystemUser findByGoogleId(String googleId) {
    Query query = entityManager
        .createQuery("select o from " + SystemUser.class.getName() + " o where o.googleId = :googleId");
    query.setParameter("googleId", googleId);
    SystemUser systemUser = (SystemUser) query.getSingleResult();
    entityManager.clear();
    return systemUser;
  }

}
