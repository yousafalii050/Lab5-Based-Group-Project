package use_case.edit_profile;


public class EditProfileInteractor implements EditProfileInputBoundary {
    private EditProfileUserDataAccessInterface userDataAccessObject;
    private EditProfileOutputBoundary editProfilePresenter;

    public EditProfileInteractor(EditProfileUserDataAccessInterface userDataAccessInterface,
                            EditProfileOutputBoundary editprofileOutputBoundary) {
        // Which parameter is the DAO and which is the presenter?
        this.userDataAccessObject = userDataAccessInterface;
        this.editProfilePresenter = editprofileOutputBoundary;
    }

    @Override
    public void execute(EditProfileInputData editprofileInputData) {
        // * get the username out of the input data,
        final String name = editprofileInputData.getName();
        // * set the username to null in the DAO
//        userDataAccessObject.setCurrentUsername(null); #todo
        // * instantiate the `LogoutOutputData`, which needs to contain the username.
        final EditProfileOutputData editprofileOutputData = new EditProfileOutputData(editprofileInputData.getName(), editprofileInputData.getGender());
        // * tell the presenter to prepare a success view.
        editProfilePresenter.prepareSuccessView(editprofileOutputData);

    }
}

