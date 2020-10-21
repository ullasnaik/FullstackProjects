import React, { Component } from 'react'

import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Filter from '../filter/Filter';
import { Link } from 'react-router-dom'

export class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLogged: this.props.isLogged,
        }
    }

    render() {
        return (<div>
            <Navbar bg="dark" variant="dark">
                <Navbar.Brand href="/dashboard">Home</Navbar.Brand>
                <Nav className="mr-auto">
                    <Nav.Link href="/readNow">ReadNow</Nav.Link>
                </Nav>
                {
                    this.state.isLogged === "yes" ?
                        <>
                            <Filter applyFilter={this.props.applyFilter} setPage={this.props.setPage}></Filter>
                            <Form inline>
                                <Link to="/">
                                    <Button variant="outline-info" >Logout</Button>
                                </Link>
                            </Form>
                        </>
                        :
                        <Form inline>
                            <Button variant="outline-info">Register</Button>
                        </Form>
                }
            </Navbar>
        </div >
        )
    }
}

export default Header
