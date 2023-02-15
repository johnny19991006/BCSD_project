<%--
  Created by IntelliJ IDEA.
  User: polic
  Date: 2022-11-23
  Time: PM 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<!--
Alpha by HTML5 UP
html5up.net | @ajlkn
Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
    <title>Alpha by HTML5 UP</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
</head>
<body class="landing is-preload">
<div id="page-wrapper">

    <!-- Header -->
    <header id="header" class="alt">
        <h1><a href="hello.jsp">Alpha</a> by HTML5 UP</h1>
        <nav id="nav">
            <ul>
                <li><a href="hello.jsp">Home</a></li>
                <li>
                    <a href="#" class="icon solid fa-angle-down">Layouts</a>
                    <ul>
                        <li><a href="generic.html">Generic</a></li>
                        <li><a href="contact.html">Contact</a></li>
                        <li><a href="elements.html">Elements</a></li>
                        <li>
                            <a href="#">Submenu</a>
                            <ul>
                                <li><a href="#">Option One</a></li>
                                <li><a href="#">Option Two</a></li>
                                <li><a href="#">Option Three</a></li>
                                <li><a href="#">Option Four</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#" class="button">Sign Up</a></li>
            </ul>
        </nav>
    </header>

    <!-- Banner -->
    <section id="banner">
        <h2>Alpha</h2>
        <p>Another fine responsive site template freebie by HTML5 UP.</p>
        <ul class="actions special">
            <li><a href="#" class="button primary">Sign Up</a></li>
            <li><a href="#" class="button">Learn More</a></li>
        </ul>
    </section>

    <!-- Main -->
    <section id="main" class="container">

        <section class="box special">
            <header class="major">
                <h2>Introducing the ultimate mobile app
                    <br />
                    for doing stuff with your phone</h2>
                <p>Blandit varius ut praesent nascetur eu penatibus nisi risus faucibus nunc ornare<br />
                    adipiscing nunc adipiscing. Condimentum turpis massa.</p>
            </header>
            <span class="image featured"><img src="${pageContext.request.contextPath}/resources/images/pic01.jpg" alt="" /></span>
        </section>

        <section class="box special features">
            <div class="features-row">
                <section>
                    <span class="icon solid major fa-bolt accent2"></span>
                    <h3>Magna etiam</h3>
                    <p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>
                </section>
                <section>
                    <span class="icon solid major fa-chart-area accent3"></span>
                    <h3>Ipsum dolor</h3>
                    <p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>
                </section>
            </div>
            <div class="features-row">
                <section>
                    <span class="icon solid major fa-cloud accent4"></span>
                    <h3>Sed feugiat</h3>
                    <p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>
                </section>
                <section>
                    <span class="icon solid major fa-lock accent5"></span>
                    <h3>Enim phasellus</h3>
                    <p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>
                </section>
            </div>
        </section>

        <div class="row">
            <div class="col-6 col-12-narrower">

                <section class="box special">
                    <span class="image featured"><img src="${pageContext.request.contextPath}/resources/images/pic02.jpg" alt="" /></span>
                    <h3>Sed lorem adipiscing</h3>
                    <p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>
                    <ul class="actions special">
                        <li><a href="#" class="button alt">Learn More</a></li>
                    </ul>
                </section>

            </div>
            <div class="col-6 col-12-narrower">

                <section class="box special">
                    <span class="image featured"><img src="${pageContext.request.contextPath}/resources/images/pic03.jpg" alt="" /></span>
                    <h3>Accumsan integer</h3>
                    <p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>
                    <ul class="actions special">
                        <li><a href="#" class="button alt">Learn More</a></li>
                    </ul>
                </section>

            </div>
        </div>

    </section>

    <!-- CTA -->
    <section id="cta">

        <h2>Sign up for beta access</h2>
        <p>Blandit varius ut praesent nascetur eu penatibus nisi risus faucibus nunc.</p>

        <form>
            <div class="row gtr-50 gtr-uniform">
                <div class="col-8 col-12-mobilep">
                    <input type="email" name="email" id="email" placeholder="Email Address" />
                </div>
                <div class="col-4 col-12-mobilep">
                    <input type="submit" value="Sign Up" class="fit" />
                </div>
            </div>
        </form>

    </section>

    <!-- Footer -->
    <footer id="footer">
        <ul class="icons">
            <li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
            <li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
            <li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
            <li><a href="#" class="icon brands fa-github"><span class="label">Github</span></a></li>
            <li><a href="#" class="icon brands fa-dribbble"><span class="label">Dribbble</span></a></li>
            <li><a href="#" class="icon brands fa-google-plus"><span class="label">Google+</span></a></li>
        </ul>
        <ul class="copyright">
            <li>&copy; Untitled. All rights reserved.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
        </ul>
    </footer>

</div>

<!-- Scripts -->
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.dropotron.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.scrollex.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/browser.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/breakpoints.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>

</body>
</html>