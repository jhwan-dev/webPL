function toggleSystem(){
    const status = document.getElementById("status");
    const button = document.getElementById("systemButton");
    const message = document.getElementById("message");
    const isOnline = status.classList.toggle("on");
    if(isOnline){
    status.textContent="ONLINE";
    button.textContent="SYSTEM STOP";
    message.textContent="시스템 활성화가 되었습니다.";
    }
    else{
        status.textContent="OFFLINE";
        button.textContent="SYSTEM START";
        message.textContent="미래의 IT가치를 탐색하는 웹서비스";
    }

}
const products=[
    {name : "AI LAPTOP", type: "COMPUTING"},
    {name : "BBB", type: "bbbbb"},
    {name : "CCC", type: "ccccccc"}

];
function loadCatalog(){
    const catalog=document.getElementById("catalog");
    // 3주차 6페이지도 replaceChild() -> replaceChildren()으로 변경!!
    catalog.replaceChildren()
    for(const product of products){
        const card=document.createElement("article");
        card.className="product-card";
        const type=document.createElement("span");
        type.className="product-type";
        type.textContent = product.type;
        const title=document.createElement("h1");
        title.textContent=product.name;
        card.appendChild(type);
        card.appendChild(title);
        catalog.appendChild(card);
    }
}
function clearCatalog(){
    const catalog=document.getElementById("catalog");
    catalog.innerHTML = '<p class="empty-message">아직 생성된 상품이 없습니다</p>';
}
document.getElementById("systemButton").addEventListener("click", toggleSystem);
document.getElementById("loadButton").addEventListener("click", loadCatalog);
document.getElementById("clearButton").addEventListener("click", clearCatalog);

const productForm=document.getElementById("productForm");

productForm.addEventListener("submit", function (event) {
    event.preventDefault();
    const name = document.getElementById("productName").value.trim();
    // html에서 id를 가져와 그 입력창에서 사용자가 입력한 값을 읽고 양쪽 공백을 제거
    const price = Number(document.getElementById("productPrice").value);
    const validationMessage = document.getElementById("validationMessage");
    const previewCard = document.getElementById("previewCard");
    document.getElementById("productName").value.trim();
    if (name.length < 2) {
        validationMessage.textContent = "상품명은 2글자 이상이어야 합니다.";
        // 이전에 성공해서 나온 카드가 남아 있지 않도록 숨김
        previewCard.classList.add("hidden");
    //     성공하면 카드가 나타나는데 그 다음에 상품명은 공백만 넣고 눌렀을때 오류메시지는 나오지만
    //     기존 상품카드가 나오기 때문에 그것을 숨겨야함
        return;
    }

    document.getElementById("previewName").textContent=name;
    document.getElementById("previewPrice").textContent=price.toLocaleString() + "원";
    document.getElementById("previewCard").classList.remove("hidden");
    document.getElementById("validationMessage").textContent="프론트 앤드 검증을 통과했습니다.";
});
//productForm 이라는 폼에서 submit 이벤트가 발생했을때 실행할 동작을 등록
