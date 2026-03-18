package com.nareshit.service;

import java.util.List;

import com.nareshit.entity.UserRegister;
import com.nareshit.model.requestDto;
import com.nareshit.model.userRequestDto;

public interface UserRegisterService {
  public UserRegister insertUserRegister(userRequestDto userRequestDTO);

  public UserRegister loginUserRegister(userRequestDto userRequestDTO);

  public requestDto retrieveDataById(Long id);

  public List<UserRegister> fetchAllDetails();





}
