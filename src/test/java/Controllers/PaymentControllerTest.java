package Controllers;

import com.example.assignment3.Database.LeaseRepository;
import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.controllers.PaymentController;
import com.example.assignment3.controllers.TenantController;
import com.example.assignment3.models.Tenant;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class PaymentControllerTest {
    LeaseRepository leaseRepository = new LeaseRepository();
    PaymentController controller= new PaymentController(leaseRepository);
    TenantRepository tenantRepository = new TenantRepository();
    TenantController controller2= new TenantController(tenantRepository);

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Starting testing for Payment Controller");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Ending testing for Payment controller");
    }

    @Before
    public  void beforeMethod(){
        System.out.println("Starting test case in Payment Controller");
    }

    @After
    public  void afterMethod(){
        System.out.println("Ending test case in Payment controller");
    }

    @Test
    public void testPayRent(){
        //arrange
        String email="abc@xyz.com" ;
        String name="abc";
        //act
        controller2.createTenant(name,email);
        Tenant tenant = leaseRepository.getSingleTenant(email);
        //assert
        assertEquals(tenant.getName()+ " " + "has paid the rent",controller.payRent(email));
    }

    @Test
    public void testDisplayAllPaidTenants()  {
        //arrange

        //act
        controller.displayAllPaidTenants();
        //assert
    }
}
