package interface_adapter.edit_profile;




public class EditProfileState {
    private String name = "";
    // private String loginError;
    private String gender = "";

    public String getName() {
        return name;
    }

    //public String getLoginError() {
    //    return loginError;
    //}

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public void setLoginError(String usernameError) {
    //    this.loginError = usernameError;
    //}

    public void setGender(String gender) {
        this.gender = gender;
    }

}