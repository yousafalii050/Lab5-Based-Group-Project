package use_case.edit_profile;

/**
 * Output Data for the Change Password Use Case.
 */
public class EditProfileOutputData {

    private final String name;
    private final String gender ;

    public EditProfileOutputData(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}