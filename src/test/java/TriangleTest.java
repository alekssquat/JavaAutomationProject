import org.junit.jupiter.api.*;

public class TriangleTest {

    Triangle normalTriangle;
    Triangle lessThenZeroTriangle;
    Triangle notATriangle;
    Triangle emptyConstructorTriangle;
    private Object NotPositiveNumberException;


    @BeforeEach
    @DisplayName("Triangle for tests created")
    @Test
    void createTriangles(){
        normalTriangle = new Triangle(3,4,5);
        lessThenZeroTriangle = new Triangle((float) 3.14,-1,44);
        notATriangle = new Triangle(2,2,8);
        emptyConstructorTriangle = new Triangle();
        System.out.println("triangles created");
    }

    @Test
    @DisplayName("Calculation of area correct normal triangle")
    void positiveCalculationArea() throws NotTriangleException, NotPositiveNumberException {
        Assertions.assertTrue((normalTriangle.calcArea())==6);
        System.out.println("normal calc completed");
    }

    @Test
    @DisplayName("Calculation of area less then zero triangle")
    void lessThenZeroException() throws NotTriangleException, NotPositiveNumberException {

        try {
            lessThenZeroTriangle.calcArea();
        }catch (NotPositiveNumberException e){
         Assertions.assertSame(lessThenZeroTriangle.calcArea(), e);
        }finally {
            System.out.println("null calc completed");
        }

    }


}
