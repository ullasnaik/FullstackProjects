
export function  getNews() {
    let res=fetch('https://newsapi.org/v2/top-headlines?country=in&apikey=d053221330ea40938614227357d544ab')
        .then(res => res.json())
        .then((data) => {
            return data.articles
        });    
    return res;
}

export async function  getReadNowNews(token) {
    console.log("token : ",token);
    let res=await fetch('http://localhost:3001/api/v1/news ',{
        method:'GET',
        headers : {
            'Content-type':"application/json",
            'Authorization': `Bearer ${token}`
        }
    })
    return await res.json();;
}

export async function  login(data) {
    console.log("username and password",data.username,data.password);
    const res = await fetch('http://localhost:3001/auth/v1',{
        method:'POST',
        headers : {
            'Content-type':"application/json"
        },
        body:JSON.stringify(data)
    })
    return await res.json();
}

export async function   addReadLater (token,data) {
    console.log("data",data);
    console.log("token",token);
    const res = await fetch('http://localhost:3001/api/v1/news',{
        method:'POST',
        headers : {
            'Content-type':"application/json",
            'Authorization': `Bearer ${token}`
        },
        body:JSON.stringify(data)
    })
    return await res.json();
}

export async function  isAuthorized  (token) {
    console.log("token : ",token);
    const res = await fetch('http://localhost:3001/auth/v1',{
        method:'POST',
        headers : {
            'Content-type':"application/json",
            'Authorization': `Bearer ${token}`
        }
    })
    return await res.json();
}



module.export={
    getNews,
    login,
    isAuthorized,
    getReadNowNews,
    addReadLater
}