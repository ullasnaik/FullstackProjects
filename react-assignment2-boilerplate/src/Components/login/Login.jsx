import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { login } from "../../Services/services";
import { Header } from '../header/Header';
import  Footer  from '../footer/Footer.jsx';
import { Redirect } from 'react-router';
import './login.css';
import { FormError } from './formError';

class Login extends React.Component {
  constructor() {
    super()
    this.state = {
      username: "",
      password: "",
      token: "",
      formErrors: { username: "", password: "" },
      usernameValid: false,
      passwordValid: false,
      formValid: false
    }
  }
  handleOnChange = (e) => {
    let name = e.target.name;
    let value = e.target.value;
    this.setState({
      [name]: value
    }, () => {
      this.validField(name, value)
    })
  }
  validField = (fieldName, value) => {
    let fieldValidationErrors = this.state.formErrors;
    let usernameValid = this.state.usernameValid;
    let passwordValid = this.state.passwordValid;
    switch (fieldName) {
      case 'username':
        usernameValid = value.length >= 3;
        fieldValidationErrors.username = usernameValid ? "" : "is invalid"
        break;
      case "password":
        passwordValid = value.length >= 6;
        fieldValidationErrors.password = passwordValid ? "" : "is too small";
        break;
      default:
        break;
    }
    this.setState({
      formErrors: fieldValidationErrors,
      usernameValid: usernameValid,
      passwordValid: passwordValid
    })

  }
  validForm() {
    this.setState({
      formValid: this.state.usernameValid && this.state.passwordValid
    })
  }
  errorClass(error) {
    return error.length === 0 ? "" : "has-error"
  }
  handleOnClick = (e) => {
    e.preventDefault();
    login(this.state).then(data => {
      localStorage.setItem("token", data.token);
      this.setState({
        token: data.token
      })
    });
  }
  render() {
    if (this.state.token) {
      return <Redirect to='/Dashboard'></Redirect>
    }
    else {
      return <div>
        <Header isLogged="no"></Header>
        <Form className="loginForm">
          <FormError formErrors={this.state.formErrors} />
          <Form.Group controlId="formBasicEmail">
            <Form.Label>User name</Form.Label>
            <Form.Control type="text" placeholder="Enter Username"
              onChange={this.handleOnChange}
              name="username"
              value={this.state.username}
              required />
          </Form.Group>

          <Form.Group controlId="formBasicPassword">
            <Form.Label>Password</Form.Label>
            <Form.Control type="password" placeholder="Password"
              onChange={this.handleOnChange}
              name="password"
              value={this.state.password}
              required
            />
          </Form.Group>
          <Button variant="primary" type="submit" onClick={this.handleOnClick}>Submit</Button>
        </Form>
        <Footer></Footer>
      </div>
    }
  }
}

export default Login