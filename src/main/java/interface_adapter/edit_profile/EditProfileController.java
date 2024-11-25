package interface_adapter.edit_profile;

import use_case.edit_profile.EditProfileInputBoundary;
import use_case.edit_profile.EditProfileInputData;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInputData;

/**
 * The controller for the Logout Use Case.
 */
public class EditProfileController {

    private EditProfileInputBoundary editprofileUseCaseInteractor;

    public EditProfileController(EditProfileInputBoundary editprofileUseCaseInteractor) {
        this.editprofileUseCaseInteractor = editprofileUseCaseInteractor;
    }

    /**
     * Executes the Logout Use Case.
     * @param name the username of the user logging in
     */
    public void execute(String name, String gender) {
        // 1. instantiate the `LogoutInputData`, which should contain the username.
        // 2. tell the Interactor to execute.
        final EditProfileInputData editprofileInputData = new EditProfileInputData(name, gender);
        editprofileUseCaseInteractor.execute(editprofileInputData);
    }
}
