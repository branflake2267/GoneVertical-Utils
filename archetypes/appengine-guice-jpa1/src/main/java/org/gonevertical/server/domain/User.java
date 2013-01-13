package org.gonevertical.server.domain;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {
  
  private String googleId;
  
  private String name;

  public User() {
    googleId = "";
  }

  public String getGoogleId() {
    return googleId;
  }

  public void setGoogleId(String googleId) {
    this.googleId = googleId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}