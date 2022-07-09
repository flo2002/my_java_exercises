package com.fileserver.Server.Config;

public class User {
    private String _username;
    private String _password;

    public User (String username, String password) {
        _username = username;
        _password = password;
    }

    public void setUsername(String username) {
        _username = username;
    }

    public String getUsername() {
        return _username;
    }

    public String getPassword() {
        return _password;
    }
}
