


const modal = document.getElementById("modal");

const span = document.getElementById("closeModal");

var perPage=3
var numberShown=0
function changePage(type){
    let elems=document.getElementsByClassName("listElem")
    let newNum=numberShown
    if (type=="next" && numberShown<elems.length )  {
        newNum+=perPage
        for(let i=0;i<elems.length;i++){

            if (i>=numberShown && i<newNum){

                elems[i].style.display=""
            }
            else{
                elems[i].style.display="none"
            }
        }

    }
    else if (type=="prev" && numberShown>perPage){
        newNum-=perPage
        console.log(newNum)
        for(let i=0;i<elems.length;i++){
            if (i<newNum && i>=newNum-perPage){
                elems[i].style.display=""
            }
            else{
                elems[i].style.display="none"
            }
        }
    }
    else if(type=="refresh"){
        for(let i=0;i<elems.length;i++){

            if (i>=numberShown-perPage && i<numberShown){

                elems[i].style.display=""
            }
            else{
                elems[i].style.display="none"
            }
        }
    }
    numberShown=newNum


}

changePage("next")

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
        console.log(document.getElementById("country"+elem.parentElement.id))
        console.log(document.getElementById("country"+elem.parentElement.id).getAttribute("countryId"))
        document.getElementById("name").value=document.getElementById("name"+elem.parentElement.id).innerHTML
        document.getElementById("country").value=document.getElementById("country"+elem.parentElement.id).getAttribute("countryId")
        document.getElementById("stars").value=document.getElementById("stars"+elem.parentElement.id).innerHTML
        document.getElementById("url").value=document.getElementById("url"+elem.parentElement.id).innerHTML
        document.getElementById("createId").value=elem.parentElement.id

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
            id: elem.parentElement.id
        },
        success: function (data, status, xhr) {
            elem.parentElement.remove()
            changePage('refresh')
        }
    });
}