package unittest.repository;


public class RemoteStringRepository implements Repository<String> {
    @Override
    public void save(String object) {
        // Make a POST call to some API
    }

    @Override
    public String load() {
        // Make a GET call to some API
        return "the response";
    }
}
