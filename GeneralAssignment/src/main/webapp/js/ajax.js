 

let listsetvice = $('.listService-Item');

listsetvice.on('click', function(){
    let nameFile = "ListService2"; 
    showData(nameFile);
})

function showData(data){
    let groupData = $('.data-show');
    groupData.html('');
    groupData.load(`${data}.html`);
}