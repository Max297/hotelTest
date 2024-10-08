<html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Страница поиска</title>

</head>

<asset:stylesheet src="apiPages.css"/>
<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Список стран </h1>
    </section>
    <div>
        <ul>
        <g:each in="${countries}" var="country">
            <li class="listElem" id="${country.getId()}">
                <p class="listParam" id="name${country.getId()}">${country.getCountryName()}</p>
                <p class="listParam" id="capital${country.getId()}">${country.getCountryCapital()}</p>
                <p class="listParam" name="redactOld" onclick="openForm(this)">Редактировать</p>
                <p class="listParam" onclick="del(this)">Удалить</p>
            </li>

        </g:each>
        </ul>
    </div>

    <button name="createNew" id="openModal" onclick="openForm(this)">Добавить новую страну</button>

    <div id="modal" class="modal">
        <div class="modal-content">
            <span class="close" id="closeModal">&times;</span>
            <h2>Данные страны</h2>
            <div id="contactForm">
                <input style="display: none" type="text" id="createId" name="createId" >
                <label for="name">Страна:</label>
                <input type="text" id="name" name="name" >
                <br>
                <label for="capital">Столица</label>
                <input type="text" id="capital" name="capital" >
                <br>
                <button onclick="sendSave()" >Сохранить</button>
            </div>
        </div>
    </div>


</div>

</body>
<asset:javascript src="apiCountry.js"/>

</html>