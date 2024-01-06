package com.teambcmsproject.teambcmsprojectspringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long Id;
    private String fname;
    private String username; 
    private String email;
    private char[] password;
    private byte[] signature_data;
    private byte[] profile_picture_data;
    


  public Long getId() {
    return this.Id;
  }

  public void setId(Long Id) {
    this.Id = Id;
  }

  public String getFname() {
    return this.fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public char[] getPassword() {
    return this.password;
  }

  public void setPassword(char[] password) {
    this.password = password;
  }

  public byte[] getSignature_data() {
    return this.signature_data;
  }

  public void setSignature_data(byte[] signature_data) {
    this.signature_data = signature_data;
  }

  public byte[] getProfile_picture_data() {
    return this.profile_picture_data;
  }

  public void setProfile_picture_data(byte[] profile_picture_data) {
    this.profile_picture_data = profile_picture_data;
  }
  




}
