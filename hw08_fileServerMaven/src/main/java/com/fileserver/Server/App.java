package com.fileserver.Server;

import com.fileserver.Server.Config.JsonUtil;
import com.fileserver.Server.Config.Properties;

public class App {
    public static void main( String[] args ) {
        // read properties, if not exist create new one
        Properties properties = (Properties) JsonUtil.readJson("config.json", Properties.class);
        
        Server server = new Server(properties);
        server.run();

    }
}
