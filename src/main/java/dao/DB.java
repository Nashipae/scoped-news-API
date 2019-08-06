package dao;

import org.sql2o.*;
import java.net.URI;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DB {
    private static URI dbUri;
    public static Sql2o sql2o;

    static {
        Logger logger = LoggerFactory.getLogger(DB.class);

        try {
            if (System.getenv("DATABASE_URL") == null) {
                dbUri = new URI("postgres://localhost:5432/scoped_news_api");
                logger.info("Using local database.");
            } else {
                dbUri = new URI(System.getenv("postgres://ozprfyupzsnftd:bef2e8c3bf123dfc309b21c33cca95397f9620e1b776701fd0041826a688a7da@ec2-107-20-198-176.compute-1.amazonaws.com:5432/d9rc9\n" +
                        "i5fkk9s7f"));
            }

            int port = dbUri.getPort();
            String host = dbUri.getHost();
            String path = dbUri.getPath();
            String username = (dbUri.getUserInfo() == null) ? "nwariara" : dbUri.getUserInfo().split(":")[0];
            String password = (dbUri.getUserInfo() == null) ? "postgres" : dbUri.getUserInfo().split(":")[1];

            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
        } catch (URISyntaxException e ) {
            logger.error("Database unavailable.");
        }
    }
}