let page = 1;

url = 'http://localhost:8080'

async function findProductById() {
    try {
        const productResponse = await fetch(`${url}/product/1`);
        const productJson = await productResponse.json()
        console.log(productJson)
        fillProductFields(productJson)
    }
    catch (error) {
        console.error(error)
    }
}

async function findProductsByPage() {
    try {
        const productResponse = await fetch(`${url}/products/page/${page}`);
        const productsJson = await productResponse.json();
        insertOnTable(productsJson.content);
    }
    catch (error) {
        console.error(error)
    }
}


async function searchProductByName() {
    const toSearch = document.querySelector('#search-bar').value;
    console.log(toSearch)
    let url = `${url}/products/filter?name=${toSearch}&size=10&page=${page}`;
    try {
        const productResponse = await fetch(url);
        const productsJson = await productResponse.json()
        clearTable();
        insertOnTable(productsJson.content)
    }
    catch (error) {
        console.error(error)
    }

}

function insertOnTable(products) {
    clearTable();
    Object.entries(products).forEach(([key, product]) => {  
        fillProductFields(product)
    })
}

function fillProductFields(product) {

    const list = '<tr>' +
        '<th scope="row" id="registrationCode"></th>' +
        '<td id="productName"></td>' +
        '<td id="productDescription"></td>' +
        '<td id="substrate"></td>' +
        '<td id="height"></td>' +
        '<td id="width"></td>' +
        '<td id="quantity"></td>' +
        '<td id="price"></td>' +
        '</tr>';

    document.querySelector('#product-list').insertAdjacentHTML("afterbegin", list);

    Object.entries(product).forEach(([key, value]) => {
        const field = `#${key}`;
        document.querySelector(field).innerHTML = value;
    });
}

function clearTable(){
    document.querySelector('#product-list').innerHTML = '';
}

function registerProduct(){

    event.preventDefault();

    const form = document.querySelector('#my-form');

    const formData = new FormData(form);

    const obj = Object.fromEntries(formData.entries());

    const jsonObj = JSON.stringify(obj);

    console.log(jsonObj);

    fetch(`${url}/product`, {
        method: "POST",
        body: jsonObj,
        headers: new Headers({"Content-Type": "application/json"})
    })
    .then(res => res.json())
    .then(data => console.log(data))
    .catch(err => console.log(err));
    
}
