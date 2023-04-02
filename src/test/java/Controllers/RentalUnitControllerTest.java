package Controllers;

import com.example.assignment3.Database.RentalUnitRepository;
import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.controllers.RentalUnitController;
import com.example.assignment3.models.AddressFactory;
import com.example.assignment3.models.Observer;
import com.example.assignment3.models.RentalUnitFactory;
import java.util.Scanner;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class RentalUnitControllerTest {
    RentalUnitFactory factory= new RentalUnitFactory();
    AddressFactory adFactory=new AddressFactory();
    Observer observer=new Observer();
    RentalUnitRepository rentalUnitrepository=new RentalUnitRepository();
    TenantRepository tenantRepository=new TenantRepository();
    RentalUnitController controller=new RentalUnitController(rentalUnitrepository,tenantRepository);

    String type="condo";
    int numOfBed=2;
    int numOfBath=1;
    int area=1000;

    Scanner s=new Scanner(System.in);
    int idinput=0;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Starting testing for Rental Unit Controller");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Ending testing for Rental Unit controller");
    }

    @Before
    public  void beforeMethod(){
        System.out.println("Starting test case in Rental Unit Controller");
    }

    @After
    public  void afterMethod(){
        System.out.println("Ending test case in Rental Unit controller");
    }

    @Test
    public void testCreateRentalUnit()  {
        //arrange
        int size=rentalUnitrepository.getAll().size();
        //act
        controller.createRentalUnit(type, numOfBed, numOfBath, area);
        //assert
        assertEquals(size+1,rentalUnitrepository.getAll().size());
    }

    @Test
    public void testRemoveRentalUnit()  {
        //arrange
        int size=rentalUnitrepository.getAll().size();
        //act
        controller.createRentalUnit(type, numOfBed, numOfBath, area);
        size++;
        System.out.println("Enter the ID of the rental unit to be removed:");
        idinput=s.nextInt();
        controller.removeRentalUnit(idinput);
        //assert
        assertEquals(size-1,rentalUnitrepository.getAll().size());
    }

    @Test
    public void testChangeRentedRent()  {
        //arrange
        //act
        System.out.println("Enter the ID of the rental unit to be changed for rent:");
        idinput=s.nextInt();
        //assert
        assertEquals(controller.changeRented(idinput,"rent"),"The type of RentalUnit is changed");
    }

    @Test
    public void testChangeRentedVacant()  {
        //arrange
        //act
        System.out.println("Enter the ID of the vacant unit for rent:");
        idinput=s.nextInt();
        //assert
        assertEquals(controller.changeRented(idinput,"vacant"),"The type of RentalUnit is changed");
    }

    @Test
    public void testDisplayAllUnits()  {
        //arrange

        //act
        controller.displayAllUnits();
        //assert
    }

    @Test
    public void testDisplayRentedUnits()  {
        //arrange

        //act
        controller.displayRentedUnits();
        //assert
    }

    @Test
    public void testVacantUnits()  {
        //arrange

        //act
        controller.vacantUnits();
        //assert
    }

    @Test
    public void testRegisterTenant()  {
        //arrange
        //act
        int count=observer.getRegistered().size();
        System.out.println("Enter the ID of the tenant to be registered:");
        idinput=s.nextInt();

        System.out.println("Enter the email of the tenant to be registered:");
        String email=s.nextLine();
        //assert

        assertEquals(count+1, observer.getRegistered().size());
    }
}
