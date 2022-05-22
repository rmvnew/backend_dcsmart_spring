package com.dcsmart.dcsmart.service.impl;

import com.dcsmart.dcsmart.controller.dto.request.ProfileRequest;
import com.dcsmart.dcsmart.controller.dto.response.ProfileResponse;
import com.dcsmart.dcsmart.exception.ProfileNotFoundException;
import com.dcsmart.dcsmart.model.Profile;
import com.dcsmart.dcsmart.repository.ProfileRepository;
import com.dcsmart.dcsmart.service.ProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
    public ProfileResponse findById(Long id) {

        Profile profile = this.profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException(
                        String.format("Perfil com id: %d, não encontrado",id)
                ));

        return ProfileResponse.converter(profile);
    }



    @Override
    public ProfileResponse update(Long id, ProfileRequest profileRequest) {

        Profile profile = this.profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException(
                        String.format("Perfil com id: %d, não encontrado",id)
                ));

        profile.setProfile_name(profileRequest.getProfile_name());
        profile.setUpdateAt(LocalDateTime.now(ZoneOffset.UTC));
        this.profileRepository.save(profile);

        return this.findById(id);
    }

    @Override
    public void delete(Long id) {

        Profile profile = this.profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException(
                        String.format("Perfil com id: %d, não encontrado",id)
                ));

        profile.setIsActive(false);
        profile.setUpdateAt(LocalDateTime.now(ZoneOffset.UTC));
        this.profileRepository.save(profile);
    }
}
