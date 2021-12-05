import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class DependencyVerifyTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Dependency dependency;

    @Test
    public void testSimpleVerify(){
        //nunca se ha utilizado
        verify(dependency, never()).getSubdepedencyClassName();
        dependency.getSubdepedencyClassName();

        //exactamente una vez
        verify(dependency, times(1)).getSubdepedencyClassName();

        //como minimo una vez
        verify(dependency, atLeast(1)).getSubdepedencyClassName();
        dependency.getSubdepedencyClassName();

        //como maximo 2
        verify(dependency, atMost(2)).getSubdepedencyClassName();
    }

    @Test
    public void testParemeters(){
        dependency.addTwo(3);
        //una vez con el parametro 3
        verify(dependency, times(1)).addTwo(3);
        dependency.addTwo(4);

        verify(dependency, times(2)).addTwo(anyInt());

    }
}
