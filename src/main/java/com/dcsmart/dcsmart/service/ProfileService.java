package com.dcsmart.dcsmart.service;

import com.dcsmart.dcsmart.controller.dto.ProfileRequest;
import com.dcsmart.dcsmart.controller.dto.ProfileResponse;
import com.dcsmart.dcsmart.model.Profile;

import java.util.List;

public interface ProfileService {

    void save(ProfileRequest profileRequest);

    List<ProfileResponse> findAll();

    Profile findById(Long id);

    Profile findByName(String name);

    Profile update(Long id, ProfileRequest profileRequest);

    void delete(Long id);

}
