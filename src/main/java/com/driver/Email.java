package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(this.password==oldPassword && newPassword.length()>=8) {
            if(checkStrong(newPassword)) {
                this.password = newPassword;
            }
        }
    }

    private boolean checkStrong(String newPassword) {
        int lower = 0, upper = 0, dig = 0, speci = 0;

        for(int i = 0; i < newPassword.length(); i++) {
            char ch = newPassword.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                upper++;
            } else if(ch >= 'a' && ch <= 'z') {
                lower++;
            } else if(ch >= '0' && ch <= '9') {
                dig++;
            } else {
                speci++;
            }
        }

        if(upper>0 && lower>0 && dig>0 && speci>0) {
            return true;
        } else {
            return false;
        }
    }
}
