package domini;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class GrupTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Grup.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void equals() {
    }

    @org.junit.Test
    public void getCodiAssig() {
    }

    @org.junit.Test
    public void getCapacitat() {
    }

    @org.junit.Test
    public void getNumGrup() {
    }

    @org.junit.Test
    public void setCodiAssig() {
    }

    @org.junit.Test
    public void setNumGrup() {
    }

    @org.junit.Test
    public void setCapacitat() {
    }
}
