package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserWarehouse {

    private volatile Map<String, UserProfile> userProfiles = new HashMap<>();

    public void add(UserProfile userProfile) {
        userProfiles.put(userProfile.getFirstName(),userProfile);
    }


    public Boolean validatePin(int userProfilePinNumber, String password) {
        UserProfile userProfile = null;
         userProfilePinNumber = userProfile.getPinNumber();

        return password.equals(userProfilePinNumber);
    }


    public void removeUserProfileByUserName(String userName) {
        userProfiles.remove(userName);
    }

}
