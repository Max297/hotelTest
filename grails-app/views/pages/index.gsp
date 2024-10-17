<html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Страница поиска</title>

</head>
<body>
<asset:stylesheet src="search.css"/>
    <div id="content" role="main" class="listCont">
        <section class="row colset-2-its">
            <h1>Введите название отеля и выберите его страну, что бы получить информацию о нем</h1>
        </section>
        <div style="text-align: center;">

            <g:form controller="pages" action="search">
                <label for="name" class="inputText">Название отеля</label>
                <input type="text" name="name" id="name" class="formInput">
                <label for="country" class="inputText">Страна отеля</label>
                <select name="country" id="country" class="formInput">
                    <option value="all">Все</option>
                    <g:each in="${countries}" var="country">
                        <option value="${country.getId()}">${country.getCountryName()}</option>
                    </g:each>
                </select>
                <g:submitButton name="Submit" value="Поиск" class="searchButton" />
            </g:form>
        </div>
    </div>

</body>
</html>