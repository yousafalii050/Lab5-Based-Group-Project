package use_case.edit_profile;

public class EditProfileInputData {
    private String name;
    private String gender;

    public EditProfileInputData(String name, String gender) {
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
