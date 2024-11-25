package interface_adapter.edit_profile;

import use_case.edit_profile.EditProfileInputData;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInputData;

/**
 * The controller for the Logout Use Case.
 */
public class EditProfileController {

    private EditProfileInputBoundary EditProfileUseCaseInteractor;

    public EditProfileController(EditProfileInputBoundary EditProfileUseCaseInteractor) {
        this.EditProfileUseCaseInteractor = EditProfileUseCaseInteractor;
    }

    /**
     * Executes the Logout Use Case.
     * @param username the username of the user logging in
     */
    public void execute(String name, String gender) {
        // 1. instantiate the `LogoutInputData`, which should contain the username.
        // 2. tell the Interactor to execute.
        final EditProfileInputData editprofileInputData = new EditProfileInputData(name, gender);
        EditProfileUseCaseInteractor.execute(editprofileInputData);
    }
}
