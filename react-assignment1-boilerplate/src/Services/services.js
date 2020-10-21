
function  getNews() {
    let res=fetch('https://newsapi.org/v2/top-headlines?country=in&apikey=d053221330ea40938614227357d544ab')
        .then(res => res.json())
        .then((data) => {
            return data.articles
        });    
    return res;
}

module.exports={
    getNews
}