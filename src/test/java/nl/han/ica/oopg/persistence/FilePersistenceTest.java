package nl.han.ica.oopg.persistence;

import nl.han.ica.oopg.logger.FileLogHandler;
import nl.han.ica.oopg.logger.LogFactory;
import nl.han.ica.oopg.logger.Logger;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.File;


public class FilePersistenceTest {
    FilePersistence filePersistence;
    String filename;


    @BeforeAll
    public static void setupClass(){
        Logger logger = LogFactory.getLogger();
        logger.addLogHandler(new FileLogHandler());
    }

    @BeforeEach
    public void setup()
    {
        filename = "test/java/nl/han/ica/oopg/persistence/Test.txt";
        filePersistence = new FilePersistence(filename);
    }

    @Test
    public void saveAndLoadDataTest()
    {
        filePersistence.saveData("testtesttesttesttesttesttesttest");
        assertEquals(filePersistence.loadDataString(), "testtesttesttesttesttesttesttest");
    }

    @Test
    public void fileExistsTestTrue()
    {
        filePersistence.saveData("testtesttesttesttesttesttesttest");
        assertTrue(filePersistence.fileExists());
    }

    @Test
    public void fileNotFoundWhenLoad()
    {
        filePersistence = new FilePersistence("test.txt");
        assertEquals(filePersistence.loadDataString(), "");
    }

    @Test
    public void saveAndLoadDataArray(){
        String[] saveData = new String[]{"Hello", "world"};
        String separator = ",";
        filePersistence.saveData(saveData, separator);
        assertArrayEquals(saveData, filePersistence.loadDataStringArray(separator));
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void saveAndLoadDataArrayWithSeparatorInTheFirstArrayValue(){
//        String[] saveData = new String[]{"Hello", "world"};
//        String separator = "w";
//        filePersistence.saveData(saveData, separator);
//        filePersistence.loadDataStringArray(separator);
//    }

    @Test
    public void deleteAnExistingFile(){
        filePersistence.saveData("Hello world");
        File file = new File("src/", filename);
        assertTrue(file.exists());
        filePersistence.deleteData();
        assertFalse(file.exists());
    }

    @Test
    public void deleteAnNotExistingFile(){
        filename = "test/java/nl/han/ica/oopg/persistence/Test2.txt";
        filePersistence = new FilePersistence(filename);
        File file = new File("src/", filename);
        assertFalse(file.exists());
        filePersistence.deleteData();
        assertFalse(file.exists());
    }

    @AfterEach
    public void after()
    {
        filePersistence.deleteData();
    }
}
