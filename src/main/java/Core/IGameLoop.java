package Core;

/**
 * Represents a game loop, that is a class that processes sequences
 * of event in the world.
 */
public interface IGameLoop {
    void Update(float deltaTime);
}
