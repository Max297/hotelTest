
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Страница поиска</title>

</head>

<asset:stylesheet src="apiPages.css"/>
<div id="content" role="main" class="listCont">
    <section class="row colset-2-its">
        <h1>Список отелей </h1>
    </section>
    <div>

        <g:each in="${hotels}" var="hotel">
            <div class="listElem" id="${hotel.getId()}">
                <div class="column">
                    <asset:image src="hotelIcon.png" class="listPic"/>
                </div>
                <div class="column">
                    <p class="listParam" id="name${hotel.getId()}">${hotel.getHotelName()}</p>
                    <p class="listParam" id="country${hotel.getId()}" countryId=${hotel.getHotelCountry().getId()}>${hotel.getHotelCountry().getCountryName()}
                    <div class="listParam" id="stars${hotel.getId()}">
                        <g:each in="${(1..hotel.getHotelStars()).toList()}" >
                            <asset:image style="width: 10px" src="star.png" />
                        </g:each>
                    </div>
                    <p class="listParam" id="url${hotel.getId()}" >${hotel.getHotelUrl()}</p>
                </div>
                <div class="column">
                    <p class="listParam" name="redactOld" onclick="openForm(this)" style="color: green">Редактировать</p>
                    <p class="listParam" onclick="del(this)" style="color: red" >Удалить</p>
                </div>
            </div>

        </g:each>

        <div class="paginationMenu">
            <button class="paginationButton" onclick="changePage('prev')"><</button>
            <button class="paginationButton" onclick="changePage('next')">> </button>
        </div>
    </div>
    <div style="text-align: center;">
        <button class="saveButton" name="createNew" id="openModal" onclick="openForm(this)">Добавить новый отель</button>
    </div>


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