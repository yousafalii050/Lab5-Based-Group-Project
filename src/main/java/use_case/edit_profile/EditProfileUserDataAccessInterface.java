package use_case.edit_profile;

import entity.User;

public interface EditProfileUserDataAccessInterface {


    void setCurrentName(User user);

    void setCurrentgender(User user);
}
