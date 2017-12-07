package no.tornadofx.charts

import eu.hansolo.fx.charts.PlotItem
import eu.hansolo.fx.charts.SankeyPlot
import javafx.event.EventTarget
import javafx.scene.paint.Color
import java.util.concurrent.ThreadLocalRandom



fun EventTarget.sankeyplot(op: (SankeyPlot.() -> Unit) = {}): SankeyPlot {
    val sp = SankeyPlot()
    sp.op()
    return sp
}

fun SankeyPlot.item(name: String, color: Color = randomColor()) {
    val plotItem = PlotItem(name, color)

    items.add(plotItem)

}

fun SankeyPlot.weightPair(item1: String, item2: String, weight: Double) =
        items.find { it.name == item1 }!!.addToOutgoing(items.find { it.name == item2 }!!, weight)

fun randomColor() = (1..3)
        .asSequence()
        .map { ThreadLocalRandom.current().nextInt(0,255) }
        .toList()
        .let { Color.rgb(it[0],it[1],it[2]) }