
export function getPlayersOnFilter(searchKey = '') {

    console.log("Filter object in service", searchKey)
    let url = 'http://localhost:9000/recommendation/api/v1/getAll'
    if (searchKey == null || searchKey == undefined || searchKey == '') {
        console.log("URL for searchKey :", url)
        let res = fetch(url,
            {
                method: 'GET',
                headers: {
                    'Content-type': "application/json"
                }
            })
            .then(res => res.json())
            .then((data) => {
                return data
            });
        return res;
    }
    url = 'https://cricapi.com/api/playerFinder?apikey=8p3AldB9YVOHfiGhgEKKEGjAHLH3&name=' + searchKey;
    console.log("URL for searchKey :", url)
    let res = fetch(url)
        .then(res => res.json())
        .then((data) => {
            return data.data
        });
    return res;

}


export async function getMyFavouritesPlayers(token) {
    console.log("token : ", token);
    let url = 'http://localhost:9000/favourite/api/v1/getAll/'+localStorage.getItem('userId');
    let res = fetch(url,
        {
            method: 'GET',
            headers: {
                'Content-type': "application/json"
            }
        })
        .then(res => res.json())
        .then((data) => {
            return data
        })
        .catch(e => {
            console.log("getMyFavouritesPlayers Api Call Error.......");
            console.log(e);
        });

    return res;
}

export async function login(data) {
    console.log("userId and password", data.userId, data.password);
    const res = await fetch('http://localhost:9000/userservice/api/v1/auth/login', {
        method: 'POST',
        headers: {
            'Content-type': "application/json"
        },
        body: JSON.stringify(data)
    })
    return await res.json();
}

export async function register(data) {
    console.log("userId and password", data.userId, data.password);
    let payload = {
        userId: data.userId,
        password: data.password,
        firstName: data.firstName,
        lastName: data.lastName,
        contact: data.contact,
        email: data.email
    }
    const res = await fetch('http://localhost:9000/userservice/api/v1/register', {
        method: 'POST',
        headers: {
            'Content-type': "application/json"
        },
        body: JSON.stringify(payload)
    })
    return await res.json();
}

export async function addToFavourite(token, data) {
    console.log("data", data);
    console.log("token", token);
    const res = await fetch('http://localhost:9000/favourite/api/v1/add', {
        method: 'POST',
        headers: {
            'Content-type': "application/json",
            'Authorization': `Bearer ${token}`
        },
        body: JSON.stringify(data)
    })
    return await res.json();
}

export async function isAuthorized(token) {
    console.log("token : ", token);
    const res = await fetch('http://localhost:3001/auth/v1', {
        method: 'POST',
        headers: {
            'Content-type': "application/json",
            'Authorization': `Bearer ${token}`
        }
    })
    return await res.json();
}

module.export = {
    login,
    register,
    isAuthorized,
    getMyFavouritesPlayers,
    addToFavourite,
    getPlayersOnFilter
}