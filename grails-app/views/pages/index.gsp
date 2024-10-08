<html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Страница поиска</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Введите название отеля и выберите его страну, что бы получить информацию о нем</h1>
    </section>
    <div>
        <g:form controller="pages" action="search">
            <input type="text" name="name">
            <select name="country">>
                <option value="all">Все</option>
                <g:each in="${countries}" var="country">
                    <option value="${country.getId()}">${country.getCountryName()}</option>
                </g:each>
            </select>
            <g:submitButton name="Submit" value="Поиск" class="lnk" />
        </g:form>
    </div>

</div>

</body>
</html>