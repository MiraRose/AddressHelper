package AddressHelper;

import AddressHelper.Model.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class CSVFileReaderTest {

    CSVFileReader csvFileReader;

    String TEST_FILE_NAME = "src/test/resources/test_file.csv";

    @BeforeEach
    public void setup() {
        csvFileReader = new CSVFileReader();
    }

    @Test
    public void testReadsInFileGivesBackArrayOfAddressesWithoutHeader() throws FileNotFoundException {
        List<Address> result = csvFileReader.getAddressesFromFile(TEST_FILE_NAME);

        Assertions.assertEquals(2, result.size());
        Assertions.assertNotEquals("City", result.get(0).getCity());
    }
}
