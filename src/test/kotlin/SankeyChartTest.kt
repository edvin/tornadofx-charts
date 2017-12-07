import eu.hansolo.fx.charts.SankeyPlot
import javafx.application.Application

fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}

class MyApp: App(MyView::class)

class MyView: View() {
    override val root = SankeyPlot().apply {
        item("ABQ")
        item("DAL")
        item("PHX")
        item("AUS")
        item("HOU")
        item("DEN")

        weightPair("ABQ", "DAL", .20)
        weightPair("ABQ", "AUS", .15)
        weightPair("ABQ", "HOU", .20)
        weightPair("ABQ", "DEN", .30)
        weightPair("ABQ", "AUS", .20)
        weightPair("ABQ", "PHX", .15)

        weightPair("PHX", "AUS", .20)
        weightPair("PHX", "DEN", .30)

        weightPair("DAL", "DEN", .20)

        streamFillMode = SankeyPlot.StreamFillMode.GRADIENT
    }
}

