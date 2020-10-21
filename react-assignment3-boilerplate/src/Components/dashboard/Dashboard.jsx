import React, { Component } from 'react'
import { Card } from '../card/Card';
import { Header } from '../header/Header';
import Footer from '../footer/Footer.jsx';
import { getNewsOnFilter } from "../../Services/services";


export class Dashboard extends Component {
    constructor() {
        super()
        this.state = {
            news: [],
            curPageNews: []
        }
    }
    componentDidMount() {
        this.applyFilter();
    }
    applyFilter = (filter = null) => {
        let promise = null;
        promise = getNewsOnFilter(filter);
        this.displayCards(promise, filter)
    }
    displayCards = (promise, filter) => {
        promise.then(news => {
            if (news.status == "error") {
                let newList = [<h3>{news.message}</h3>, <h3>{news.message}</h3>];
                this.setState({
                    news: newList
                })
            }
            else {
                let newList = news.articles;
                this.setState({
                    news: newList
                },
                    () => {
                        let curPageNews = this.setPage(filter);
                        this.setState({
                            curPageNews: curPageNews
                        });
                    });

            }
        })
    }

    setPage = (filter = null) => {
        let pageSize, pageNum;
        if (filter == null) {
            pageSize = 20;
            pageNum = 1;
        } else {
            pageSize = filter.pageSize;
            pageNum = filter.page;
        }
        var index = 0;
        var arrayLength = this.state.news.length;
        var tempArray = [];
        for (index = 0; index < arrayLength; index += pageSize) {
            let myChunk = this.state.news.slice(index, index + pageSize);
            tempArray.push(myChunk);
        }
        if (tempArray[pageNum - 1] == undefined) {
            return tempArray[tempArray.length - 1];
        }
        return tempArray[pageNum - 1];
    }

    render() {
        return (
            <div>
                <Header isLogged="yes" applyFilter={this.applyFilter} setPage={this.setPage}></Header>
                <div className="wrap-content container-fluid">
                    {this.state.curPageNews.length > 0
                        ?
                        <section id="box-main" className="container-fluid">
                            <div className="row">
                                {this.state.curPageNews.map((item) => <Card key={item.title} news={item}></Card>)}
                            </div>
                        </section>
                        :
                        <h1 className="text-center">Loading..</h1>
                    }
                </div>
                <Footer></Footer>
            </div>
        )
    }
}

export default Dashboard;
