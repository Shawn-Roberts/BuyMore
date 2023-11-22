package com.BuyMore.UserServices.DTO

class ApplicationUserDTO {
    private Long userID
    private String firstName
    private String lastName
    private String email

    Long getUserID() { return userID }
    String getFirstName() { firstName }
    String getLastName() { return lastName }
    String getEmail() { return email }

    void setUserID(Long id) { this.userID = id }
    void setFirstName(String firstName) { this.firstName = firstName }
    void setLastName(String lastName) { this.lastName = lastName }
    void setEmail(String email) { this.email = email }
}
