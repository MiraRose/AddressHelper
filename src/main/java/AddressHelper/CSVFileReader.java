package AddressHelper;

import AddressHelper.Model.Address;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVFileReader {

    public List<Address> getAddressesFromFile(String fileName) throws FileNotFoundException {
        List<Address> addresses = new ArrayList<>();

        Scanner scanner = new Scanner(new File(fileName));

        // skip the header
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String addressLine = scanner.nextLine();
            String[] addressLineArray = addressLine.split(",");
            Address address = new Address();
            address.setStreetAddress(addressLineArray[0]);
            address.setCity(addressLineArray[1]);
            address.setPostalCode(addressLineArray[2]);
            addresses.add(address);
        }

        return addresses;
    }
}
