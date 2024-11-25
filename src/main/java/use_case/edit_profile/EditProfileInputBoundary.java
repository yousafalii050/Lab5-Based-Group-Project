package use_case.edit_profile;

import use_case.change_password.ChangePasswordInputData;


/**
 * The Edit Profile Use Case.
 */
public interface EditProfileInputBoundary {

    /**
     * Execute the Change Password Use Case.
     * @param editprofileInputData the input data for this use case
     */
    void execute(EditProfileInputData editprofileInputData);

}

