package com.dcsmart.dcsmart.controller.dto;

import com.dcsmart.dcsmart.model.Profile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileResponse {

    private Long profileId;

    private String profile_name;



    public static ProfileResponse converter(Profile profile){

        var currentProfile = new ProfileResponse();
        currentProfile.setProfileId(profile.getProfileId());
        currentProfile.setProfile_name(profile.getProfile_name());
        return currentProfile;
    }


}
