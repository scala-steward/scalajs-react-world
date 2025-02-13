package io.github.mvillafuertem

import io.github.mvillafuertem.facade.{ DataSet, Network }
import org.scalajs.dom
import slinky.hot
import slinky.web.ReactDOM
import slinky.web.html.div
import typings.materialUiCore.createMuiThemeMod.{ Theme, ThemeOptions }
import typings.materialUiCore.createTypographyMod.TypographyOptions
import typings.materialUiCore.stylesMod
import typings.materialUiStyles.components.ThemeProvider

import scala.scalajs.js.Dictionary
import scala.scalajs.{ js, LinkingInfo }
import scala.scalajs.js.annotation.JSExportTopLevel

object Main {

  val theme: Theme = stylesMod.createMuiTheme(
    ThemeOptions()
      .setTypography(TypographyOptions().setUseNextVariants(true)) // https://v3.material-ui.com/style/typography/#migration-to-typography-v2
  )

  @JSExportTopLevel("main")
  def main(): Unit = {
    if (LinkingInfo.developmentMode)
      hot.initialize()

    val container = Option(dom.document.getElementById("root")).getOrElse {
      val elem = dom.document.createElement("div")
      elem.id = "root"
      dom.document.body.appendChild(elem)
      elem
    }

    ReactDOM.render(Graph(), container)
  }
}
