<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="mainPages.css"/>

    <g:layoutHead/>
</head>

<body class="bodyStyle">
<div class="headerPanel">
    <a href="http://localhost:8080">Страница поиска</a>
    <a href="http://localhost:8080/countryPage">Список стран</a>
    <a href="http://localhost:8080/hotelPage">Список отелей</a>
    <a href="http://localhost:8080/h2-console/">Консоль h2</a>
</div>
<div class="bodyCont">
<g:layoutBody/>
</div>
<div class="footerSite" role="contentinfo">
    <p>Наши контакты</p>
    <div>
        <asset:image class="footerImages" src="contactIcons/vk.png" />
        <asset:image class="footerImages" src="contactIcons/wa.png" />
        <asset:image class="footerImages" src="contactIcons/tg.png" />
    </div>
</div>


<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>
</html>
