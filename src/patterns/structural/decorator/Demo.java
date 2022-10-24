package patterns.structural.decorator;

import patterns.structural.decorator.decorators.CompressionDecorator;
import patterns.structural.decorator.decorators.DataSource;
import patterns.structural.decorator.decorators.DataSourceDecorator;
import patterns.structural.decorator.decorators.EncryptionDecorator;
import patterns.structural.decorator.decorators.FileDataSource;

public class Demo {
    public static void main(String[] args) {
    	String sFile = "./src/patterns/structural/composite/OutputDemo.txt";
    	
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                                         new EncryptionDecorator(
                                             new FileDataSource(sFile)));
        encoded.writeData(salaryRecords);
        // Decorator will figure out which one comes first. Just call writeData
        
        DataSource plain = new FileDataSource(sFile);

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}
