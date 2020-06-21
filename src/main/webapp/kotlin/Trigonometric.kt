/**
 * Создать сервлет и взаимодействующие с ним пакеты и HTML-документы.
 * Готовое веб-приложение должно запускаться на сервере Tomcat.
 * Вычисление тригонометрических функций в градусах и радианах с указанной точностью.
 * */

import java.io.PrintWriter
import java.math.BigDecimal
import java.math.RoundingMode
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.math.PI

@WebServlet(name="Trig", value= ["/trig"])
open class Trig: HttpServlet(){
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.setContentType("text/html; charset=UTF-8")
        val writer: PrintWriter = resp.getWriter()

        val func = req.getParameter("func")
        val valueType = req.getParameter("valueType")
        val value = req.getParameter("value").toDouble()
        val precision = req.getParameter("precision").toInt()
        val result = calc(func, valueType, value, precision)

        writer.use { writer ->
            writer.println("<head><title>Trigonometric result</title></head>")
            writer.println("<h2 align=center>Вычисление тригонометрических функций</h2>")
            writer.println("<h3 align=center weight=normal>Вычислить: $func($value $valueType) с точностью $precision</h3>")
            writer.println("<h3 align=center weight=normal>Результат: $result</h3>")
        }
    }
}

fun calc(func: String, valueType: String, value: Double, precision: Int): Double {
    var valueForFunc = translate(valueType, value)
    return calcRes(func, valueForFunc, precision)
}

fun calcRes(func: String, valueForFunc: Double, precision: Int): Double {
    var funcRes = 0.0
    if (func == "sin")
        funcRes = Math.sin(valueForFunc)
    else if (func == "cos")
        funcRes = Math.cos(valueForFunc)
    else if (func == "tan")
        funcRes = Math.tan(valueForFunc)
    return round(funcRes, precision)
}

fun translate(valueType: String, value: Double): Double {
    var valueForFunc = 0.0
    if (valueType == "deg")
        valueForFunc = valueTypeDegrees(value)
    else if (valueType == "rad")
        valueForFunc = valueTypeRadians(value)
    return valueForFunc
}

fun valueTypeDegrees(deg: Double): Double {
    return Math.toRadians(deg)
}

fun valueTypeRadians(rad: Double): Double {
    return rad * PI
}

fun round(d: Double, pr: Int): Double {
    return BigDecimal(d).setScale(pr, RoundingMode.UP).toDouble()
}