// Получаем элементы
const modal = document.getElementById("modal");

const span = document.getElementById("closeModal");



function changePage(type){

    let curPage=new URLSearchParams(window.location.search).get('page')
    if (curPage==null){
        curPage=1
    }
    curPage=parseInt(curPage)
    if (type=="next"  )  {
        curPage+=1
        window.location.href = "http://localhost:8080/countryPage?page="+curPage;

    }
    else {
        if (curPage!=1){
            curPage-=1
        }
        window.location.href = "http://localhost:8080/countryPage?page="+curPage;
    }


}




// Закрыть модальное окно при нажатии на (x)
span.onclick = function() {
    modal.style.display = "none";
}

// Закрыть модальное окно при нажатии вне его
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

function openForm(elem){
    modal.style.display = "block";

    if (elem.getAttribute("name")=="redactOld"){
        document.getElementById("name").value=document.getElementById("name"+elem.parentElement.parentElement.id).innerHTML
        document.getElementById("capital").value=document.getElementById("capital"+elem.parentElement.parentElement.id).innerHTML
        document.getElementById("createId").value=elem.parentElement.parentElement.id

    }
    else{
        document.getElementById("name").value=""
        document.getElementById("capital").value=""
        document.getElementById("createId").value=-1
    }
}
function sendSave(){
    if (document.getElementById("createId").value!=-1){
        $.ajax({
            type: 'POST',
            dataType:"json",
            url: '/country/update',
            data: {
                id: document.getElementById("createId").value,
                name: document.getElementById("name").value,
                capital: document.getElementById("capital").value
            },
            success: function (data, status, xhr) {

                alert(data['message'])

                let paramId=document.getElementById("createId").value
                document.getElementById("name"+paramId).innerHTML=document.getElementById("name").value
                document.getElementById("capital"+paramId).innerHTML=document.getElementById("capital").value
                span.click()
            }
        });
    }
    else{
        $.ajax({
            type: 'POST',
            dataType:"json",
            url: '/country/add',
            data: {
                name: document.getElementById("name").value,
                capital: document.getElementById("capital").value
            },
            success: function (data, status, xhr) {

                alert(data['message'])
                span.click()
            }
        });
    }
}

function del(elem){
    $.ajax({
        type: 'POST',
        dataType:"json",
        url: '/country/delete',
        data: {
            id: elem.parentElement.parentElement.id
        },
        success: function (data, status, xhr) {
            window.location.href = "http://localhost:8080/countryPage";
        }
    });
}


