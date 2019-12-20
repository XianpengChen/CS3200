<%@ page import="Objects.Committee" %>
<%@ page import="java.util.List" %>
<%@ page import="Objects.People" %><%--
  Created by IntelliJ IDEA.
  User: 28609
  Date: 4/16/2019
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>view committees</title>
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
        <h1 class="w3-border-bottom w3-border-light-grey w3-padding-16">All committees are here!</h1>
    </div>

    <div class="w3-container w3-row-padding w3-grayscale" method="post">
        <% List<Committee> comms = (List<Committee>) request.getAttribute("committees");
            List<People> chairs = (List<People>) request.getAttribute("chairs");
            List<People> vice_chairs = (List<People>) request.getAttribute("vice_chairs");
            for (int i = 0; i < comms.size(); i++) {%>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <img src="//////////////" width="250px" height="250px">
            <h3><%= comms.get(i).getName()%>
            </h3>
            <p class="w3-opacity">chair: <%= chairs.get(i).getFirstName() + " " + chairs.get(i).getLastName()%>
            </p>
            <p class="w3-opacity">vice chair: <%= vice_chairs.get(i).getFirstName() + " "
                    + vice_chairs.get(i).getLastName()%>
            </p>
            <p><%= comms.get(i).getAgenda()%>
            </p>
            <p>
            <form action="${pageContext.request.contextPath}/singleCommittee" method="post">
            <button class="w3-button w3-black w3-section" value="<%= comms.get(i).getCommittee_id()%>" name="committee_id">
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

