import dk.sdu.mmmi.cbse.main.moduleConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
public class GameConfigIntegrationTest {
    @Test
    public void testAllCoreServicesAreLoaded() {
        try (var context = new AnnotationConfigApplicationContext(moduleConfig.class)) {
            assertNotNull(context.getBean("gamePluginServices"), "Game plugin services should be available");
            assertNotNull(context.getBean("entityProcessingServiceList"), "Entity processing services should be available");
            assertNotNull(context.getBean("postEntityProcessingServices"), "Post-processing services should be available");
        }
    }
}
