import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TriangleTest {

    private static Logger logger= LoggerFactory.getLogger(TriangleTest.class);

    @Nested
    @DisplayName("Набор основных проверок треугольника")
    class BasicCheckUps{

        Triangle normalTriangle;
        Triangle lessThenZeroTriangle;
        Triangle notATriangle;


        @BeforeEach
        @DisplayName("Triangle for tests created")
        @Test
        void createTriangles(){
            normalTriangle = new Triangle(3,4,5);
            lessThenZeroTriangle = new Triangle((float) 3.14,-1,44);
            notATriangle = new Triangle(2,2,8);
            System.out.println("triangles created");
        }

        @Test
        @DisplayName("Calculation of area correct normal triangle")
        void positiveCalculationArea() throws NotTriangleException, NotPositiveNumberException {
            assertTrue((normalTriangle.calcArea())==6);

            System.out.println("normal triangle area calculation completed");
        }

        @Test
        @DisplayName("values less than zero")
        void lessThenZeroException() throws NotPositiveNumberException {
            NotPositiveNumberException thrown = assertThrows(
                    NotPositiveNumberException.class,
                    () -> {lessThenZeroTriangle.calcArea();});
            assertTrue(thrown.getClass().equals(NotPositiveNumberException.class));
            System.out.println("Values have to be positive");
        }

        @Test
        @DisplayName("Values unacceptable")
        void notTriangle() throws NotTriangleException {
            NotTriangleException thrown = assertThrows(
                    NotTriangleException.class,
                    () -> {notATriangle.calcArea();});
            assertTrue(thrown.getClass().equals(NotTriangleException.class));
            System.out.println("Sum of two shorties sides have to be bigger than longest one");
        }
    }

    @Test
    void someTriangleTest() {
        Triangle someTriangle=new Triangle();
        someTriangle.a=18;
        someTriangle.b=1;
        someTriangle.c=-2;

        NotPositiveNumberException thrown = assertThrows(
                NotPositiveNumberException.class,
                () -> {someTriangle.calcArea();});
        assertTrue(thrown.getClass().equals(NotPositiveNumberException.class));
        System.out.println("Values have to be positive");

    }

    @ParameterizedTest
    @ValueSource(floats = {5, (float) 19.12,-4,0,-0})
    void someTriangleTest(float param) {
        Triangle someTriangle=new Triangle();
        someTriangle.a=3;
        someTriangle.b=4;
        someTriangle.c=param;

        try {
            assumeTrue(someTriangle.calcArea()>0);
            System.out.println(someTriangle.calcArea());
        } catch (NotPositiveNumberException e) {
            e.printStackTrace();
        } catch (NotTriangleException e) {
            e.printStackTrace();
        }

    }




}
