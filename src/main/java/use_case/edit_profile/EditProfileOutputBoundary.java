package use_case.edit_profile;


/**
 * The Edit Profile Use Case.
 */
public interface EditProfileOutputBoundary {

    /**
     * Execute the Change Password Use Case.
     * @param editprofileOutputData the input data for this use case
     */
    void execute(EditProfileOutputData editprofileOutputData);

}
