import React, { Component } from 'react'
import { DisplayCard } from '../displayCard/DisplayCard';
import { Header } from '../header/Header';
import Footer from '../footer/Footer.jsx';
import { getMyFavouritesPlayers } from "../../Services/services";


export class MyFavourites extends Component {
    constructor() {
        super()
        this.state = {
            players: []
        }
    }
    componentDidMount() {
        this.getCardList()
    }
    getCardList() {
        console.log("calling api....");
        let promise = getMyFavouritesPlayers(localStorage.getItem('token'));
        console.log("api call compled....");
        promise.then(players => {
            console.log(players);
            let playerList = players;
            this.setState({
                players: playerList
            },
                () => {
                    console.log(this.state.players);
                }
            );

        })
    }
    render() {
        return (
            <div>
                <Header isLogged="yes"></Header>
                <div className="wrap-content container-fluid">
                    {this.state.players.length > 0
                        ?
                        <section id="box-main" className="container-fluid">
                            <div className="row">
                                {this.state.players.map((item) => <DisplayCard key={item.title} player={item}></DisplayCard>)}
                            </div>
                        </section>
                        :
                        <h1 className="text-center">...</h1>
                    }
                </div>
                <Footer></Footer>
            </div>
        )
    }
}

export default MyFavourites;
