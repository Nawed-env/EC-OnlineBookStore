package com.nareshit.serviceImpl;

import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nareshit.entity.UserRegister;
import com.nareshit.entity.UserRegisterMongo;
import com.nareshit.model.requestDto;
import com.nareshit.model.userRequestDto;
import com.nareshit.repository.UserRegisterMongoRepo;
import com.nareshit.repository.UserRegisterRepo;
import com.nareshit.service.UserRegisterService;

@Service
public class UserRegisterServiceImpl
        implements UserRegisterService {

    @Autowired
    private UserRegisterRepo userRegisterRepo;

    @Autowired
    private UserRegisterMongoRepo userRegisterMongoRepo;

    private static final Logger logger =
            LoggerFactory.getLogger(UserRegisterServiceImpl.class);

    // ================= EXISTING LOGIC (NO CHANGE) =================

    @Override
    public UserRegister insertUserRegister(userRequestDto userRequestDTO) {
        logger.info("Registration service layer calling or started");

        UserRegister user = new UserRegister();
        try {
            user.setFirstName(userRequestDTO.getFirstName());
            user.setLastName(userRequestDTO.getLastName());
            user.setEmail(userRequestDTO.getEmail());
            user.setPassword(
                Base64.getEncoder()
                      .encodeToString(userRequestDTO.getPassword().getBytes())
            );
            user.setContactId(userRequestDTO.getContactId());
            userRegisterRepo.save(user);

            UserRegisterMongo mongo = new UserRegisterMongo();
            mongo.setFirstName(userRequestDTO.getFirstName());
            mongo.setLastName(userRequestDTO.getLastName());
            mongo.setEmail(userRequestDTO.getEmail());
            mongo.setPassword(
                Base64.getEncoder()
                      .encodeToString(userRequestDTO.getPassword().getBytes())
            );
            mongo.setContactId(userRequestDTO.getContactId());
            userRegisterMongoRepo.save(mongo);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public UserRegister loginUserRegister(userRequestDto userRequestDTO) {
        return Optional.ofNullable(
                    userRegisterRepo.findByEmail(userRequestDTO.getEmail())
               )
               .filter(user ->
                   new String(
                       Base64.getDecoder().decode(user.getPassword())
                   ).equals(userRequestDTO.getPassword())
               )
               .orElse(null);
    }

    @Override
    public requestDto retrieveDataById(Long id) {
        Optional<UserRegister> byId = userRegisterRepo.findById(id);
        UserRegister userRegister = byId.get();
        return new requestDto(
                userRegister.getFirstName(),
                userRegister.getLastName()
        );
    }

    @Override
    @Cacheable(value = "getAll")
    public List<UserRegister> fetchAllDetails() {
        return userRegisterRepo.findAll();
    }

    // ================= ONLY SECURITY ADDITION =================

    /**
     * Spring Security uses this method internally
     * JWT filter + AuthenticationProvider depend on this
     */
//    @Override
//    public UserDetails loadUserByUsername(String email)
//            throws UsernameNotFoundException {
//
//        UserRegister user = userRegisterRepo.findByEmail(email);
//
//        if (user == null) {
//            throw new UsernameNotFoundException(
//                "User not found with email: " + email
//            );
//        }
//
//        return new User(
//                user.getEmail(),
//                user.getPassword(),
//                Collections.emptyList()
//        );
//    }
}
