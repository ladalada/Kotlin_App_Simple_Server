<%--Создать массив дат и вывести самую позднюю дату.--%>

<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dates</title>
    <style>
        h3 {
            font-weight: normal;
            text-align: center;
        }
        h2 {
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <%
        int num = 10;
        boolean a = true;
        List<Date> dates = new ArrayList<>();
        for (int i = 1; i < num;) {
            Date date = new Date(2020, 3, i);
            if (a) {
                i += 3;
                a = false;
            } else {
                i -= 2;
                a = true;
            }
            dates.add(date);
        }
        Date lastDate = getLastDate(dates);
    %>
    <%!
        private Date getLastDate(List<Date> dates) {
            Date last = dates.get(0);
            for (Date date: dates) {
                if (date.getTime() > last.getTime()) {
                    last = date;
                }
            }
            return last;
        }
    %>
    <h2>Вывод поздней даты</h2>
    <h2>Массив дат:</h2>
    <%
        for (Date date: dates) {
    %>
    <h3><%= date %></h3>
    <% } %>
    <h2>Самая поздняя дата:</h2>
    <h3><%= lastDate %></h3>
</div>
</body>
</html>