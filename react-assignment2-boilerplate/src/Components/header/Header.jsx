import React, { Component } from 'react'

import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';


export class Header extends Component {

    constructor(props) {
        super(props)
        this.state = {
            isLogged: this.props.isLogged
        }
    }

    render() {
        return (<div>
            <Navbar bg="dark" variant="dark">
                <Navbar.Brand href="/dashboard">Home</Navbar.Brand>
                <Nav className="mr-auto">
                    <Nav.Link href="/readNow">ReadNow</Nav.Link>
                </Nav>
                <Form inline>
                    {
                        this.state.isLogged === "yes" ?
                            <Button variant="outline-info">Logout</Button>
                            :
                            <Button variant="outline-info">Register</Button>
                    }
                </Form>
            </Navbar>
        </div >
        )
    }
}

export default Header
