


const modal = document.getElementById("modal");

const span = document.getElementById("closeModal");

function changePage(type){

    let curPage=new URLSearchParams(window.location.search).get('page')
    if (curPage==null){
        curPage=1
    }
    curPage=parseInt(curPage)
    if (type=="next" )  {
        curPage+=1
        window.location.href = "http://localhost:8080/hotelPage?page="+curPage;

    }
    else {
        if (curPage!=1){
            curPage-=1
        }
        window.location.href = "http://localhost:8080/hotelPage?page="+curPage;
    }


}


span.onclick = function() {
    modal.style.display = "none";
}


window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

function openForm(elem){
    modal.style.display = "block";

    if (elem.getAttribute("name")=="redactOld"){

        document.getElementById("name").value=document.getElementById("name"+elem.parentElement.parentElement.id).innerHTML
        document.getElementById("country").value=document.getElementById("country"+elem.parentElement.parentElement.id).getAttribute("countryId")
        document.getElementById("stars").value=document.getElementById("stars"+elem.parentElement.parentElement.id).children.length
        document.getElementById("url").value=document.getElementById("url"+elem.parentElement.parentElement.id).innerHTML
        document.getElementById("createId").value=elem.parentElement.parentElement.id

    }
    else{
        document.getElementById("name").value=""
        document.getElementById("country").value=1
        document.getElementById("stars").value=""
        document.getElementById("url").value=""
        document.getElementById("createId").value=-1
    }
}
function sendSave(){
    if (document.getElementById("createId").value!=-1){
        $.ajax({
            type: 'POST',
            dataType:"json",
            url: '/hotel/update',
            data: {
                id: document.getElementById("createId").value,
                name: document.getElementById("name").value,
                country: document.getElementById("country").value,
                stars:document.getElementById("stars").value,
                url:document.getElementById("url").value
            },
            success: function (data, status, xhr) {

                alert(data['message'])

                let paramId=document.getElementById("createId").value

                document.getElementById("name"+paramId).innerHTML=document.getElementById("name").value
                document.getElementById("country"+paramId).setAttribute("countryId",document.getElementById("country").value)
                document.getElementById("country"+paramId).innerHTML=document.getElementById("country").options[document.getElementById("country").value].text
                document.getElementById("stars"+paramId).innerHTML=document.getElementById("stars").value
                document.getElementById("url"+paramId).innerHTML=document.getElementById("url").value

                span.click()

            }
        });
    }
    else{
        $.ajax({
            type: 'POST',
            dataType:"json",
            url: '/hotel/add',
            data: {
                name: document.getElementById("name").value,
                country: document.getElementById("country").value,
                stars:document.getElementById("stars").value,
                url:document.getElementById("url").value
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
        url: '/hotel/delete',
        data: {
            id: elem.parentElement.parentElement.id
        },
        success: function (data, status, xhr) {
            window.location.href = "http://localhost:8080/hotelPage";
        }
    });
}