import React, { Component } from 'react'
import { DisplayCard } from '../displayCard/DisplayCard';
import { Header } from '../header/Header';
import Footer from '../footer/Footer.jsx';
import { getReadNowNews } from "../../Services/services";


export class ReadNow extends Component {
    constructor() {
        super()
        this.state = {
            news: []
        }
    }
    componentDidMount() {
        this.getCardList()
    }
    getCardList() {
        let promise = getReadNowNews(localStorage.getItem('token'));
        promise.then(news => {
            let newList = news.map((item) => <DisplayCard key={item.title} news={item}></DisplayCard>);
            this.setState({
                news: newList
            },
                () => {
                    console.log(this.state.news);
                }
            );

        })
    }
    render() {
        return (
            <div>
                <Header isLogged="yes"></Header>
                <div className="wrap-content container-fluid">
                    {this.state.news.length > 0
                        ?
                        <section id="box-main" className="container-fluid">
                            <div className="row">
                                {this.state.news}
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

export default ReadNow;
