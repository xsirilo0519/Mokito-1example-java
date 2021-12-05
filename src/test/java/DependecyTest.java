import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


public class DependecyTest {
    @Mock
    private SubDependency subDependency;

    private  Dependency dependency;

    @Before
    public void setupMock(){
       // dependency=mock(Dependency.class);
        subDependency=mock(SubDependency.class);
        dependency= new Dependency(subDependency);
    }



    @Test
    public void testSubdependency(){
        when(subDependency.getClassName()).thenReturn("hi there 2");

        assertEquals("hi there 2",dependency.getSubdepedencyClassName());
    }

    @Test
    public void testAddTwoAny(){
        when(dependency.addTwo(anyInt())).thenReturn(0);

        assertEquals(0, dependency.addTwo(3));
        assertEquals(0, dependency.addTwo(80));
    }

     /*Se que esto no es bueno pero son las otras prubas para entender el tema

    @Test
    public void testDependency() {
        when(dependency.getClassName()).thenReturn("hi there");

        assertEquals("hi there", dependency.getClassName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException() {
        when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);

        dependency.getClassName();
    }

    @Test
    public void testAddTwo(){
        when(dependency.addTwo(1)).thenReturn(20);

        assertEquals(20, dependency.addTwo(1));
        assertEquals(0, dependency.addTwo(27));

        // ¿Por qué funciona poniendo solo assertEquals(0, dependency.addTwo(27));
    }*/
}
