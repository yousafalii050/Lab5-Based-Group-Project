package interface_adapter.edit_profile;

import use_case.edit_profile.EditProfileOutputBoundary;
import use_case.edit_profile.EditProfileOutputData;
import view.EditProfileView;

public class EditProfilePresenter implements EditProfileOutputBoundary {
    private final EditProfileViewModel editprofileViewModel;

    public EditProfilePresenter(EditProfileViewModel editprofileViewModel){
        this.editprofileViewModel = editprofileViewModel;
    }

    @Override
    public void execute(EditProfileOutputData editprofileOutputData) {

    }
}
