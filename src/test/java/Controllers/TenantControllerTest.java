package Controllers;

import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.controllers.TenantController;
import org.junit.*;

import static org.junit.Assert.assertEquals;


public class TenantControllerTest {

    TenantRepository tenantRepository = new TenantRepository();
    TenantController controller= new TenantController(tenantRepository);
    String name="abc";
    String email="abc@xyz.com";

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Starting testing for Tenant Controller");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Ending testing for Tenant controller");
    }

    @Before
    public  void beforeMethod(){
        System.out.println("Starting test case in Tenant Controller");
    }

    @After
    public  void afterMethod(){
        System.out.println("Ending test case in Tenant controller");
    }

    @Test
    public void testCreateTenant()  {
        //arrange
        int size=tenantRepository.getAll().size();
        //act
        controller.createTenant(name,email);
        //assert
        assertEquals(size+1,tenantRepository.getAll().size());
    }

    @Test
    public void testRemoveTenant()  {
        //arrange
        int size=tenantRepository.getAll().size();
        //act
        controller.createTenant(name,email);
        size++;
        controller.removeTenant(email);
        //assert
        assertEquals(size-1,tenantRepository.getAll().size());
    }

    @Test
    public void testDisplayAllTenants()  {
        //arrange

        //act
        controller.displayTenants();
        //assert
    }
}
