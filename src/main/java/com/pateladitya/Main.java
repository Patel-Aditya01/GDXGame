import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.pateladitya.GDXWindow;
import org.lwjgl.system.Configuration;

void main() {
    Configuration.GLFW_CHECK_THREAD0.set(false);
    var config = new Lwjgl3ApplicationConfiguration();
    config.setWindowedMode(900, 600);
    config.useVsync(true);
    config.setResizable(false);
    config.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate + 1);
    new Lwjgl3Application(new GDXWindow(), config);
}
