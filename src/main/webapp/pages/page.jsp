<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<link href="index.css" type="text/css" rel="stylesheet">
<head>
    <title>Trigonometric</title>
    <style>
        h3 {
            font-weight: normal;
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <form action="trig" method="POST">
        <h2> Вычисление тригонометрических функций </h2>
        <h3>
            Функция: <input type="radio" name="func" value ="sin"/>sin
            <input type="radio" name="func" value="cos"/>cos
            <input type="radio" name="func" value="tan"/>tan
            <br>
            Измерение угла в: <input type="radio" name="valueType" value ="deg"/>deg
            <input type="radio" name="valueType" value="rad"/>rad
            <br>
            Введите величину угла (Double): <input type="text" name="value" />
            <br>
            Введите точность (Int): <input type="text" name="precision" />
            <br>
        </h3>
        <h2><input type="submit" value="Вычислить"></h2>

    </form>
</div>
</body>
</html>