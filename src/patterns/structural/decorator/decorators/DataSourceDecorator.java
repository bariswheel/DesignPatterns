package patterns.structural.decorator.decorators;

public class DataSourceDecorator implements DataSource {
    private DataSource wrappee; // LEO : I'm receiving a reference

    DataSourceDecorator(DataSource source) {
        this.wrappee = source; // LEO: And then I'm pointing to that reference. 
        // This is the constructor, EncryptionDecorator has a super() that calls this that creates the reference, "and pointing" signed LEO.

    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}
