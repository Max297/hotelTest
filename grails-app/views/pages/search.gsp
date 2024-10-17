<html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Найденные отели</title>
</head>

<body>
<asset:stylesheet src="search.css"/>

<div id="content" role="main" class="listCont">
    <section class="row colset-2-its">
        <h1>Количество найденных отелей: ${hotels.size()} </h1>
    </section>

    <div>
        <g:if test="${hotels.size() > 0}">
            <table>
                <thead>
                    <tr>
                        <th>Звездность</th>
                        <th>Название</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${hotels}" var="hotel">
                        <tr>
                            <td>
                                <g:each in="${(1..hotel.getHotelStars()).toList()}" >
                                    <asset:image style="width: 10px" src="star.png" />
                                </g:each>
                            </td>
                            <g:if test="${hotel.getHotelUrl() !=null}">
                                <td>
                                    <p>${hotel.getHotelName() }</p>
                                    <a href="${hotel.getHotelUrl() }">Перейти на сайт</a>
                                </td>
                            </g:if>
                            <g:else>
                                <td>${hotel.getHotelName() }</td>
                            </g:else>
                        </tr>
                    </g:each>
                </tbody>
            </table>
        </g:if>
        <g:else>
            По Вашему запросу ничего не найдено
        </g:else>


    </div>
    <div style="text-align: center">
        <a href="/" class="finalText">Новый поиск</a>
    </div>


</div>

</body>
</html>