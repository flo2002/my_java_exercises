package com.fileserver.Server.Config;

import java.util.ArrayList;
import java.util.List;

public class Properties {
    private Integer _port;
    private String _root;
    private List<User> _users = new ArrayList<User>();

    public Properties(Integer port, String root, User user) {
        _port = port;
        _root = root;
        _users.add(user);
    }

    public Integer getPort() {
        return _port;
    }

    public String getRoot() {
        return _root;
    }

    public Boolean checkAuthentication(String username, String password) {
        for (User user : _users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
