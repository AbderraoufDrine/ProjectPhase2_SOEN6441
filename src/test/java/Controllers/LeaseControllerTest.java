package Controllers;

import com.example.assignment3.Database.LeaseRepository;
import com.example.assignment3.Database.RentalUnitRepository;
import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.controllers.LeaseController;
import java.text.ParseException;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class LeaseControllerTest {
    LeaseRepository leaseRepository = new LeaseRepository();
    TenantRepository tenantRepository = new TenantRepository();
    RentalUnitRepository rentalUnitRepository = new RentalUnitRepository();
    LeaseController controller= new LeaseController(tenantRepository,rentalUnitRepository,leaseRepository);

    @BeforeClass
    public  static void beforeClass(){
        System.out.println("Starting testing for Lease Controller");
    }

    @AfterClass
    public  static void afterClass(){
        System.out.println("Ending testing for Lease controller");
    }

    @Before
    public  void beforeMethod(){
        System.out.println("Starting test case in Lease Controller");
    }

    @After
    public  void afterMethod(){
        System.out.println("Ending test case in Lease controller");
    }

    @Test
    public void testRentUnit() throws ParseException {
        //arrange
        String email="abc@xyz.com" ;
        int Id=2;
        String startDate="01-02-2023";
        String endDate="01-03-2023";
        double rent=750.0;

        int size=leaseRepository.getAll().size();
        //act
        controller.rentUnit(email, Id, startDate, endDate, rent);
        //assert
        assertEquals(size+1,leaseRepository.getAll().size());
    }

    @Test
    public void testDisplayLeases()  {
        //arrange

        //act
        controller.displayLeases();
        //assert
    }

    @Test
    public void testDisplayTenantsInLeases()  {
        //arrange

        //act
        controller.displayTenantsInLeases();
        //assert
    }
}
