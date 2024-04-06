import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import kz.edu.sdu.dogs.App
import model.ModelView
import java.awt.Dimension

fun main() = application {
    val modelView = ModelView()
    Window(
        title = "RandomDogs",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)
        App(modelView, modifier = Modifier.fillMaxSize())
    }
}
//.\gradlew :composeApp:run