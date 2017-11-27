import org.junit.*;

public class MyClass {
    @BeforeClass
    public static void init(){
        System.out.println("init");
    }

    @Before
    public void setup(){
        System.out.println("setup");

    }
    @Test
    public void test1(){
        System.out.println("hello");

    }
    @After
    public void tearDown(){
        System.out.println("tear down");

    }
    @AfterClass
    public static void destroy(){
        System.out.println("destroy");

    }

}
