<%--
  Created by IntelliJ IDEA.
  User: 28609
  Date: 4/8/2019
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Model United Nation</title>
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
            <a href="#about" class="w3-bar-item w3-button">About</a>
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
    <div class="w3-container w3-padding-32" id="about">
        <h1 class="w3-border-bottom w3-border-light-grey w3-padding-16">Welcome to MUN!</h1>
        <p>Model United Nations, also known as Model UN or MUN, is an educational simulation and/or academic activity in
            which students can learn about diplomacy, international relations, and the United Nations. MUN involves and
            teaches participants speaking, debating, and writing skills, in addition to critical thinking, teamwork, and
            leadership abilities. Usually an extracurricular activity, some schools also offer Model UN as a class.
            It is meant to engage students and allow them to develop deeper understanding into current world issues.
        </p>
    </div>

    <div class="w3-container w3-row-padding w3-grayscale">
        <h1 class="w3-border-bottom w3-border-light-grey w3-padding-16" id="committee">Committees</h1>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <h3>Security Council</h3>
            <p>The Security Council has primary responsibility for the maintenance of international peace and security.
                It has 15 Members, and each Member has one vote. Under the Charter of the United Nations, all Member
                States are obligated to comply...</p>
            <p><button class="w3-button w3-light-grey w3-block">more details</button></p>
        </div>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <h3>Human Rights Committee</h3>
            <p>The Human Rights Council is an inter-governmental body within the United Nations system responsible for
                strengthening the promotion and protection of human rights around the globe and for addressing
                situations of human rights violations...</p>
            <p><button class="w3-button w3-light-grey w3-block">more details</button></p>
        </div>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <h3>World Health Organization</h3>
            <p>WHO began when our Constitution came into force on 7 April 1948 – a date we now celebrate every year as
                World Health Day. We are now more than 7000 people from more than 150 countries working in 150 country
                offices, in 6 regional offices...</p>
            <p><button class="w3-button w3-light-grey w3-block">more details</button></p>
        </div>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <h3>International Monetary Fund</h3>
            <p>The International Monetary Fund (IMF) is an organization of 189 countries, working to foster global
                monetary cooperation, secure financial stability, facilitate international trade, promote high employment
                and sustainable economic growth, and...</p>
            <p><button class="w3-button w3-light-grey w3-block">more details</button></p>
        </div>
    </div>

    <div class="w3-container w3-row-padding w3-grayscale" id="event">
        <h1 class="w3-border-bottom w3-border-light-grey w3-padding-16">Events</h1>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <img src="//////////////"  width="250px" height="250px">
            <h3>Opening Ceremony</h3>
            <p class="w3-opacity">EST 9:00-10:00 AM, 4.12.2019</p>
            <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
            <p><button class="w3-button w3-light-grey w3-block">Register</button></p>
        </div>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <img src="/////////"  width="250px" height="250px">
            <h3>Press Conference</h3>
            <p class="w3-opacity">EST 9:00-10:30 AM, 4.13.2019</p>
            <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
            <p><button class="w3-button w3-light-grey w3-block">Register</button></p>
        </div>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <img src="........"  width="250px" height="250px">
            <h3>Security Council Session</h3>
            <p class="w3-opacity">EST 8:00-10:00 AM, 4.14.2019</p>
            <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
            <p><button class="w3-button w3-light-grey w3-block">Register</button></p>
        </div>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <img src="/////////"  width="250px" height="250px">
            <h3>WHO Hearing</h3>
            <p class="w3-opacity">EST 7:00-8:00 PM, 4.15.2019</p>
            <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
            <p><button class="w3-button w3-light-grey w3-block">Register</button></p>
        </div>
    </div>


    <div class="w3-container w3-row-padding w3-grayscale" id="people">
        <h1 class="w3-border-bottom w3-border-light-grey w3-padding-16">People</h1>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <img src="//////////////"  width="250px" height="250px">
            <h3>John Doe</h3>
            <p class="w3-opacity">Chair of Security Council</p>
            <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
            <p><button class="w3-button w3-light-grey w3-block">Contact</button></p>
        </div>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <img src="/////////"  width="250px" height="250px">
            <h3>Jane Doe</h3>
            <p class="w3-opacity">Chair of Human Rights Committee</p>
            <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
            <p><button class="w3-button w3-light-grey w3-block">Contact</button></p>
        </div>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <img src="........"  width="250px" height="250px">
            <h3>Mike Ross</h3>
            <p class="w3-opacity">Chair of WHO</p>
            <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
            <p><button class="w3-button w3-light-grey w3-block">Contact</button></p>
        </div>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <img src="/////////"  width="250px" height="250px">
            <h3>Dan Star</h3>
            <p class="w3-opacity">Chair of IMF</p>
            <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
            <p><button class="w3-button w3-light-grey w3-block">Contact</button></p>
        </div>
    </div>

    <!-- Contact Section -->
    <div class="w3-container w3-padding-32" id="contact">
        <h1 class="w3-border-bottom w3-border-light-grey w3-padding-16">Contact</h1>
        <p>Lets get in touch and talk about our project.</p>
        <form action="//////" target="_blank">
            <input class="w3-input w3-border" type="text" placeholder="Name" required name="Name">
            <input class="w3-input w3-section w3-border" type="text" placeholder="Email" required name="Email">
            <input class="w3-input w3-section w3-border" type="text" placeholder="Subject" required name="Subject">
            <input class="w3-input w3-section w3-border" type="text" placeholder="Comment" required name="Comment">
            <button class="w3-button w3-black w3-section" type="submit">
                <i class="fa fa-paper-plane"></i> SEND MESSAGE
            </button>
        </form>
    </div>

    <!-- End page content -->
</div>


<!-- Footer -->
<footer class="w3-center cornflowerblue w3-padding-16">
    <p>CS 3200 PROJECT, SECTION 3 GROUP 5</p>
</footer>

</body>
</html>
