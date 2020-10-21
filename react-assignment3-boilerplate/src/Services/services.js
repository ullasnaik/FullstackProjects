
export function getNewsOnFilter(filter) {

    console.log("Filter object in service", filter)
    let url = 'https://newsapi.org/v2/'
    if (filter == null || filter == undefined) {
        url += 'top-headlines?country=in&apikey=d053221330ea40938614227357d544ab'
    }
    else {
        if (filter.endpoints == "" || filter.endpoints == "top-headlines") {
            url += 'top-headlines?apikey=d053221330ea40938614227357d544ab'
            if (filter.country == "") {
                url += '&country=in'
            } else {
                url += '&country=' + filter.country
            }
            if (filter.category != "") {
                url += '&category=' + filter.category
            }

        } else {
            url += filter.endpoints + '?apikey=d053221330ea40938614227357d544ab'
            if (filter.key == "") {
                url += '&q=' + 'india'
            } else {
                url += '&q=' + filter.key
            }
            if (filter.page != 1) {
                url += '&page=' + filter.page
            }
        }
    }
    console.log("URL for filter :", url)
    let res = fetch(url)
        .then(res => res.json())
        .then((data) => {
            return data
        });
    return res;
}

export function getSourceList(country) {
    console.log('calling api for source', country)
    if (country == null || country == "") {
        country = 'in'
    }
    let url = 'https://newsapi.org/v2/sources?country=' + country + '&apikey=d053221330ea40938614227357d544ab'
    console.log("Source URL", url)
    let res = fetch(url)
        .then(res => res.json())
        .then((data) => {
            return data
        });
    console.log('called api for source')
    return res;
}


export async function getReadNowNews(token) {
    console.log("token : ", token);
    let res = await fetch('http://localhost:3001/api/v1/news ', {
        method: 'GET',
        headers: {
            'Content-type': "application/json",
            'Authorization': `Bearer ${token}`
        }
    })
    return await res.json();;
}

export async function login(data) {
    console.log("username and password", data.username, data.password);
    const res = await fetch('http://localhost:3001/auth/v1', {
        method: 'POST',
        headers: {
            'Content-type': "application/json"
        },
        body: JSON.stringify(data)
    })
    return await res.json();
}

export async function addReadLater(token, data) {
    console.log("data", data);
    console.log("token", token);
    const res = await fetch('http://localhost:3001/api/v1/news', {
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
    isAuthorized,
    getReadNowNews,
    addReadLater,
    getSourceList,
    getNewsOnFilter
}