package com.language_practice_server.server_demo.web.dto;

public class UserDto {
    private Long id;
    //@NotNull, @Email, @Size - valid annotations.
    //@NotBlank - valid annotation
    private String userName;
    //@Valid - valid annotation
    private PersonDto personDto;

    public UserDto() {
    }

    public UserDto(Long id, String userName, PersonDto personDto) {
        this.id = id;
        this.userName = userName;
        this.personDto = personDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", personDto=" + personDto +
                '}';
    }
}
