<%@ page import="Objects.People" %>
<%@ page import="java.util.List" %>
<%@ page import="Objects.Committee" %><%--
  Created by IntelliJ IDEA.
  User: 28609
  Date: 4/15/2019
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
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
            <a href="/munApp_war_exploded/view/bloc" class="w3-bar-item w3-button">Bloc</a>
            <a href="/munApp_war_exploded/view/people" class="w3-bar-item w3-button">People</a>
            <a href="/munApp_war_exploded/admin" class="w3-bar-item w3-button">Admin</a>
        </div>
    </div>
</div>

<div class="w3-content w3-padding" style="max-width:1564px">
    <div class="w3-container w3-padding-32">
        <h1 class="w3-border-bottom w3-border-light-grey w3-padding-16">Add People</h1>
        <form action="${pageContext.request.contextPath}/AddPeople" method="post">
            <input class="w3-input w3-border" type="text" placeholder="First name" required name="First name">
            <input class="w3-input w3-section w3-border" type="text" placeholder="Last name" required name="Last name">
            <input class="w3-input w3-section w3-border" type="email" placeholder="Email" required name="Email">
            <input class="w3-input w3-section w3-border" type="password" placeholder="Password" required name="Password">
            <input class="w3-input w3-section w3-border" type="tel" placeholder="Phone number" required name="Phone number">
            <input class="w3-input w3-section w3-border" type="text" placeholder="Profile" required name="Profile">
            <input class="w3-input w3-section w3-border" type="text" placeholder="Special accommodation" required name="Special accommodation">
            <input class="w3-button w3-black w3-section" type="submit" value="Submit">
        </form>
    </div>

    <div class="w3-container w3-padding-32">
        <h1 class="w3-border-bottom w3-border-light-grey w3-padding-16">Add Bloc</h1>
        <form action="${pageContext.request.contextPath}/AddBloc" method="post">
            <input class="w3-input w3-border" type="text" placeholder="Bloc name" required name="Bloc name">
            <select class="w3-input w3-section w3-border" required name="toCommittee">
            <% List<Committee> comms = (List<Committee>) request.getAttribute("committees");
                for(Committee comm : comms){%>
            <option value="<%= comm.getCommittee_id()%>"> <%= comm.getName()%></option>
                <%}%>
            </select>

            <input class="w3-button w3-black w3-section" type="submit" value="Submit">
        </form>
    </div>

    <div class="w3-container w3-padding-32">
        <h1 class="w3-border-bottom w3-border-light-grey w3-padding-16">Add Committee</h1>
        <form action="${pageContext.request.contextPath}/AddCommittee" method="post">
            <input class="w3-input w3-border" type="text" placeholder="Committee name" required name="Committee name">
            <input class="w3-input w3-section w3-border" type="text" placeholder="Agenda" required name="Agenda">
            Chair: <select class="w3-input w3-section w3-border" required name="Chair">
                <% List<People> ps = (List<People>) request.getAttribute("people");
                    for(People p : ps){%>
                <option value="<%= p.getPeopleID()%>"> <%= p.getFirstName() + " " + p.getLastName()%></option>
                <%}%>
            </select>
            Vice Chair: <select class="w3-input w3-section w3-border" required name="Vice chair">
                <% for(People p : ps){%>
                <option value="<%= p.getPeopleID()%>"> <%= p.getFirstName() + " " + p.getLastName()%></option>
                <%}%>
            </select>
            <input class="w3-button w3-black w3-section" type="submit" value="Submit">
        </form>
    </div>
    <div class="w3-container w3-padding-32">
        <h1 class="w3-border-bottom w3-border-light-grey w3-padding-16">Add Event</h1>
        <form action="${pageContext.request.contextPath}/AddEvent" method="post">
            <input class="w3-input w3-border" type="text" placeholder="Event name" required name="Event name">
            <input class="w3-input w3-section w3-border" type="text" placeholder="Place" required name="Place">
            Start Time: <input class="w3-input w3-section w3-border" type="datetime-local" required name="Start time">
            End Time: <input class="w3-input w3-section w3-border" type="datetime-local" required name="End time">
            <input class="w3-input w3-section w3-border" type="text" placeholder="Description" required name="Description">
            <input class="w3-button w3-black w3-section" type="submit" value="Submit">
        </form>
    </div>
</div>

<footer class="w3-center cornflowerblue w3-padding-16">
    <p>CS 3200 PROJECT, SECTION 3 GROUP 5</p>
</footer>


</body>
</html>
