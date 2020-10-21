import React, { Component } from 'react'
import { Card } from '../card/Card';
import { Header } from '../header/Header';
import Footer from '../footer/Footer.jsx';
import { getPlayersOnFilter } from "../../Services/services";
import { Form, FormControl } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';


export class Home extends Component {
    constructor() {
        super()
        this.state = {
            players: [],
            curPlayers: [],
            searchKey: null,
            isSearch: false
        }
    }
    componentDidMount() {
        this.applyFilter(this.state.searchKey);
    }

    handleChange = e => {
        this.setState({ searchKey: e.target.value });

    };

    applyFilter = (searchKey = null) => {
        if (this.state.searchKey == null || this.state.searchKey == undefined || this.state.searchKey == '') {
            this.setState({ isSearch: false });
        } else {
            this.setState({ isSearch: true });
        }
        let promise = null;
        promise = getPlayersOnFilter(searchKey);
        this.displayCards(promise, searchKey)
    }
    displayCards = (promise, searchKey) => {
        promise.then(players => {
            let playerList = players;
            console.log(players)
            this.setState({
                curPlayers: playerList
            });
        })
    }

    render() {
        return (
            <div>
                <Header isLogged="yes" ></Header>
                <div>
                    <Form inline>
                        <FormControl type="text" placeholder="Search Player" className="mr-sm-12" onChange={this.handleChange} />
                        <Button onClick={() => this.applyFilter(this.state.searchKey)} name="search" variant="outline-info">Search</Button>
                    </Form>
                </div>
                <div>
                    {this.state.isSearch
                        ?
                        <h2>Search Result</h2>
                        :
                        <h2>Recommended Players</h2>
                    }
                </div>
                <div className="wrap-content container-fluid">
                    {this.state.curPlayers.length > 0
                        ?
                        <section id="box-main" className="container-fluid">
                            <div className="row">
                                {this.state.curPlayers.map((item) => <Card key={item.title} player={item}></Card>)}
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

export default Home;
