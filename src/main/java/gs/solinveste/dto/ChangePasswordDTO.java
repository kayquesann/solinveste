package gs.solinveste.dto;

public class ChangePasswordDTO {

    private String newPassword;

    public ChangePasswordDTO() {
    }

    public ChangePasswordDTO(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
