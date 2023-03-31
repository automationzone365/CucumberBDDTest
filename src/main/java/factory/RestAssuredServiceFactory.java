package factory;

import rest.RestAssuredClient;

public class RestAssuredServiceFactory {
    //public RestAssuredClient restAssuredClient;
    public static ThreadLocal<RestAssuredClient> tlRestAssuredClient = new ThreadLocal<>();
    private static final Object object = new Object();
    private static RestAssuredServiceFactory instance = null;

    private RestAssuredServiceFactory() {
    }

    public static RestAssuredServiceFactory getInstance() {
        if (instance != null) return instance;
        synchronized (object) {
            if (instance == null) instance = new RestAssuredServiceFactory();
        }
        return instance;
    }

    public static void registerClient() {
        tlRestAssuredClient.set(new RestAssuredClient());

    }

    public static RestAssuredClient getRestAssuredClient() {
        return tlRestAssuredClient.get();
    }
}
