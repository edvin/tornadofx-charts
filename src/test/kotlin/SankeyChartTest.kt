import eu.hansolo.fx.charts.SankeyPlot
import javafx.application.Application
import no.tornadofx.charts.*
import tornadofx.*

fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}

class MyApp: App(MyView::class)

class MyView: View() {
    override val root = SankeyPlot().apply {
        item("Albuquerque")
        item("Dallas")
        item("Phoenix")
        item("Austin")
        item("Houston")
        item("Denver")

        weightPair("Albuquerque", "Dallas", .20)
        weightPair("Albuquerque", "Austin", .15)
        weightPair("Albuquerque", "Houston", .20)
        weightPair("Albuquerque", "Denver", .30)
        weightPair("Albuquerque", "Austin", .20)
        weightPair("Albuquerque", "Phoenix", .15)

        weightPair("Phoenix", "Austin", .20)
        weightPair("Phoenix", "Denver", .30)

        weightPair("Dallas", "Denver", .20)

        streamFillMode = SankeyPlot.StreamFillMode.GRADIENT
    }
}

