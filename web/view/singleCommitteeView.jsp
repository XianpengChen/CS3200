<%@ page import="Objects.Committee" %>
<%@ page import="Objects.People" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 28609
  Date: 4/17/2019
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%Committee committee = (Committee) request.getAttribute("committee");%>

<title><%= committee.getName()%></title>
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

<div class="w3-content w3-padding" style="max-width:1564px">
    <!-- About Section -->
    <div class="w3-container w3-padding-32">
        <h1 class="w3-border-bottom w3-border-light-grey w3-padding-16">All members of <%= committee.getName()%> are here!</h1>
    </div>
    <div class="w3-container w3-row-padding w3-grayscale">
        <% List<People> ps = (List<People>) request.getAttribute("members");
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
    <div class="w3-container w3-padding-32">
        <h1 class="w3-border-bottom w3-border-light-grey w3-padding-16">Add a people to this committee</h1>
        <form action="${pageContext.request.contextPath}/addPeopleToCommittee" method="post">
            <select class="w3-input w3-section w3-border" required name="newMember">
                <% List<People> ms = (List<People>) request.getAttribute("notMembers");
                    for(People p : ms){%>
                <option value="<%= p.getPeopleID()%>"> <%= p.getFirstName() + " " + p.getLastName()%></option>
                <%}%>
            </select>
            <select class="w3-input w3-section w3-border" required name="currentCommittee">
                <option value="<%= committee.getCommittee_id()%>"> <%= committee.getName()%></option>
            </select>
            <input class="w3-input w3-section w3-border" type="text" placeholder="allocation" required name="allocation">
            <input class="w3-button w3-black w3-section" type="submit" value="Add">
        </form>
    </div>
    <div class="w3-container w3-padding-32">
        <h1 class="w3-border-bottom w3-border-light-grey w3-padding-16">Delete a member from this committee</h1>
        <form action="${pageContext.request.contextPath}/deletePeopleFromCommittee" method="post">
            <select class="w3-input w3-section w3-border" required name="delMember">
                <% List<People> me = (List<People>) request.getAttribute("members");
                    for(People p : me){%>
                <option value="<%= p.getPeopleID()%>"> <%= p.getFirstName() + " " + p.getLastName()%></option>
                <%}%>
            </select>
            <select class="w3-input w3-section w3-border" required name="currentCommittee">
                <option value="<%= committee.getCommittee_id()%>"> <%= committee.getName()%></option>
            </select>
            <input class="w3-button w3-black w3-section" type="submit" value="Delete">
        </form>
    </div>

</div>
<footer class="w3-center cornflowerblue w3-padding-16">
    <p>CS 3200 PROJECT, SECTION 3 GROUP 5</p>
</footer>
</body>
</html>
