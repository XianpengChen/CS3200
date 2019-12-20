<%@ page import="Objects.People" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 28609
  Date: 4/16/2019
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<title>view people</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<!-- Navbar (sit on top) -->
<div class="w3-top">
    <div class="w3-bar w3-white w3-wide w3-padding w3-card">
        <a href="/munApp_war_exploded" class="w3-bar-item w3-button" style="font-size: x-large">Model United Nation</a>
        <!-- Float links to the right. Hide them on small screens -->
        <div class="w3-right w3-hide-small">
            <a href="/munApp_war_exploded/#about" class="w3-bar-item w3-button">About</a>
            <a href="/munApp_war_exploded/view/committee" class="w3-bar-item w3-button">Committees</a>
            <a href="/munApp_war_exploded/view/event" class="w3-bar-item w3-button">Events</a>
            <a href="/munApp_war_exploded/view/bloc" class="w3-bar-item w3-button">Blocs</a>
            <a href="/munApp_war_exploded/view/people" class="w3-bar-item w3-button">People</a>
            <a href="/munApp_war_exploded/admin" class="w3-bar-item w3-button">Admin</a>
        </div>
    </div>
</div>

<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">
    <!-- About Section -->
    <div class="w3-container w3-padding-32">
        <h1 class="w3-border-bottom w3-border-light-grey w3-padding-16">All people are here!</h1>
    </div>

    <div class="w3-container w3-row-padding w3-grayscale" id="people" method ="post">
        <% List<People> ps = (List<People>) request.getAttribute("people");
            for(People p : ps){%>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <img src="//////////////" width="250px" height="250px">
            <h3><%= p.getFirstName() + " " + p.getLastName()%></h3>
            <p class="w3-opacity"><%= p.getEmail()%></p>
            <p><%= p.getProfile()%></p>
            <p>
            <form action="${pageContext.request.contextPath}/singlePeople" method="post">
                <button class="w3-button w3-black w3-section" value="<%= p.getPeopleID()%>" name="people_id">
                    More details
                </button>
            </form>
            </p>
        </div>
        <%}%>
    </div>
    <!-- End page content -->
</div>
<!-- Footer -->
<footer class="w3-center cornflowerblue w3-padding-16">
    <p>CS 3200 PROJECT, SECTION 3 GROUP 5</p>
</footer>

</body>
</html>
