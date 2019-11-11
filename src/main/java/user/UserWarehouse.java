package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserWarehouse {

    private volatile Map<Integer, UserProfile> userProfiles = new HashMap<>();

    public void addUserProfile(UserProfile userProfile) {
        userProfiles.put(userProfile.getPinNumber(),userProfile);
    }

    public UserProfile getUserProfile(Integer pin) {return userProfiles.get(pin); }

    public void removeUserProfile(Integer pin) {
        userProfiles.remove(pin);
    }

}
