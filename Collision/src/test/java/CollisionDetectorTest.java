import dk.sdu.mmmi.cbse.collisionsystem.CollisionDetector;
import dk.sdu.mmmi.cbse.common.data.Entity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CollisionDetectorTest {

    @Test
    public void testEntitiesCollide() {
        // Arrange
        Entity entity1 = mock(Entity.class);
        Entity entity2 = mock(Entity.class);

        when(entity1.getX()).thenReturn(0.0);
        when(entity1.getY()).thenReturn(0.0);
        when(entity1.getRadius()).thenReturn(5f);

        when(entity2.getX()).thenReturn(3.0);
        when(entity2.getY()).thenReturn(4.0);
        when(entity2.getRadius()).thenReturn(5f);

        CollisionDetector detector = new CollisionDetector();

        // Act
        boolean result = detector.collides(entity1, entity2);

        // Assert
        assertTrue(result, "Entities should collide (distance = 5, radius sum = 10)");
    }

    @Test
    public void testEntitiesDoNotCollide() {
        // Arrange
        Entity entity1 = mock(Entity.class);
        Entity entity2 = mock(Entity.class);

        when(entity1.getX()).thenReturn(0.0);
        when(entity1.getY()).thenReturn(0.0);
        when(entity1.getRadius()).thenReturn(3f);

        when(entity2.getX()).thenReturn(10.0);
        when(entity2.getY()).thenReturn(0.0);
        when(entity2.getRadius()).thenReturn(3f);

        CollisionDetector detector = new CollisionDetector();

        // Act
        boolean result = detector.collides(entity1, entity2);

        // Assert
        assertFalse(result, "Entities should not collide (distance = 10, radius sum = 6)");
    }
}
