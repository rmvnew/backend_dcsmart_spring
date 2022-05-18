package com.dcsmart.dcsmart.service.impl;

import com.dcsmart.dcsmart.controller.dto.ProfileRequest;
import com.dcsmart.dcsmart.controller.dto.ProfileResponse;
import com.dcsmart.dcsmart.model.Profile;
import com.dcsmart.dcsmart.repository.ProfileRepository;
import com.dcsmart.dcsmart.service.ProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void save(ProfileRequest profileRequest) {

        var profile = new Profile();
        profile.setProfile_name(profileRequest.getProfile_name());
        profile.setIsActive(true);
        profile.setCreateAt(LocalDateTime.now());
        profile.setUpdateAt(LocalDateTime.now());

        this.profileRepository.save(profile);

    }

    @Override
    public List<ProfileResponse> findAll() {
        var profiles = this.profileRepository.findAll();
        return profiles.stream()
                .map(ProfileResponse::converter)
                .collect(Collectors.toList());
    }

    @Override
    public Profile findById(Long id) {
        return null;
    }

    @Override
    public Profile findByName(String name) {
        return null;
    }

    @Override
    public Profile update(Long id, ProfileRequest profileRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
