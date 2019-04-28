package unittest.repository;


public class RemoteStringRepository implements Repository<String> {
    private String object;


    @Override
    public void save(String object) {
       this.object=object;
    }

    @Override
    public String load() {
      return object;
    }
}
