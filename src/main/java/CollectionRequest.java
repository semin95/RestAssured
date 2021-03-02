public abstract class CollectionRequest {

    private static String baseURI = Configuration.getInstance("configuration").getValue("baseURI");
    private static String basePath = Configuration.getInstance("configuration").getValue("basePath");

    public CollectionRequest() {
    }

    public static String getBaseURI() {
        return baseURI;
    }

    public static String getBasePath() {
        return basePath;
    }
}
