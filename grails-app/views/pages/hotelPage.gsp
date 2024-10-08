
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Страница поиска</title>

</head>

<asset:stylesheet src="apiPages.css"/>
<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Список отелей </h1>
    </section>
    <div>
        <ul>
            <g:each in="${hotels}" var="hotel">
                <li class="listElem" id="${hotel.getId()}">
                    <p class="listParam" id="name${hotel.getId()}">${hotel.getHotelName()}</p>
                    <p class="listParam" id="country${hotel.getId()}" countryId=${hotel.getHotelCountry().getId()}>${hotel.getHotelCountry().getCountryName()}
                    <p class="listParam" id="stars${hotel.getId()}">${hotel.getHotelStars()}</p>
                    <p class="listParam" id="url${hotel.getId()}" >${hotel.getHotelUrl()}</p>

                    <p class="listParam" name="redactOld" onclick="openForm(this)">Редактировать</p>
                    <p class="listParam" onclick="del(this)">Удалить</p>
                </li>

            </g:each>
        </ul>
    </div>

    <button name="createNew" id="openModal" onclick="openForm(this)">Добавить новый отель</button>

    <div id="modal" class="modal">
        <div class="modal-content">
            <span class="close" id="closeModal">&times;</span>
            <h2>Данные страны</h2>
            <div id="contactForm">
                <input style="display: none" type="text" id="createId" name="createId" >
                <label for="name">Название:</label>
                <input type="text" id="name" name="name" >
                <br>
                <select name="country" id ="country">
                    <g:each in="${countries}" var="country">
                        <option value="${country.getId()}">${country.getCountryName()}</option>
                    </g:each>
                </select>
                <br>
                <label for="stars">Звезды:</label>
                <input type="text" id="stars" name="stars" >
                <br>
                <label for="url">Сайт:</label>
                <input type="text" id="url" name="url" >
                <br>
                <button onclick="sendSave()" >Сохранить</button>
            </div>
        </div>
    </div>


</div>

</body>
<asset:javascript src="apiHotel.js"/>

</html>