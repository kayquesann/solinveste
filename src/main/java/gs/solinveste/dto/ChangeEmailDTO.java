package gs.solinveste.dto;

public class ChangeEmailDTO {

    private String newEmail;

    public ChangeEmailDTO() {
    }

    public ChangeEmailDTO(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
