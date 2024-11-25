package interface_adapter.edit_profile;

import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;

/**
 * The View Model for the Login View.
 */
public class EditProfileViewModel extends ViewModel<EditProfileState> {
    public EditProfileViewModel() {
        super("log in");
        setState(new EditProfileState());
    }

}




public class LoginViewModel extends ViewModel<LoginState> {

    public LoginViewModel() {
        super("log in");
        setState(new LoginState());
    }

}

