import React, { Component } from 'react'

import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { Link } from 'react-router-dom'

export class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLogged: this.props.isLogged,
        }
    }

    render() {
        if (this.state.isLogged === "yes") {
            return (<div>
                <Navbar bg="dark" variant="dark">
                    <Navbar.Brand href="/home">Cric Players</Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="mr-auto">
                        <Nav.Link href="/myFavourites">MyFavourites</Nav.Link>
                    </Nav>
                    <Form inline>
                        <Link to="/">
                            <Button variant="outline-info" >Logout</Button>
                        </Link>
                    </Form>
                    </Navbar.Collapse>
                </Navbar>
            </div >
            )
        }else{
            return (<div>
                <Navbar bg="dark" variant="dark">
                    <Navbar.Brand href="/home">Cric Players</Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Link to="/register">
                            <Button variant="outline-info" >Register</Button>
                        </Link>
                    </Navbar.Collapse>
                </Navbar>
            </div >
            )

        }
    }
}

export default Header
