import React, { Component } from 'react'
import { Card } from '../card/Card';
import { getNews } from "../../Services/services";
export class Dashboard extends Component {
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
        let promise = getNews();
        promise.then(news => {
            let newList = news.map((item) => <Card key={item.title} news={item}></Card>);
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
        )
    }
}

export default Dashboard
