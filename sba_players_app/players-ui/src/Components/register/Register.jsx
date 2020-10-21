import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { register } from "../../Services/services";
import { Header } from '../header/Header';
import Footer from '../footer/Footer.jsx';
import { Redirect } from 'react-router';
import './register.css';
import { FormError } from './formError';

class Register extends React.Component {
  constructor() {
    super()
    this.state = {
      userId: "",
      password: "",
      firstName: "",
      lastName: "",
      contact: "",
      email: "",
      token: "",
      formErrors: { userId: "", password: "", error: "" },
      userIdValid: false,
      passwordValid: false,
      formValid: false,
      isSuccess: false
    }
  }
  componentWillMount() {
    localStorage.removeItem("token");
    localStorage.removeItem("userId");
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
    let userIdValid = this.state.userIdValid;
    let passwordValid = this.state.passwordValid;
    switch (fieldName) {
      case 'userId':
        userIdValid = value.length >= 3;
        fieldValidationErrors.userId = userIdValid ? "" : "is invalid"
        break;
      case "password":
        passwordValid = value.length >= 3;
        fieldValidationErrors.password = passwordValid ? "" : "is invalid";
        break;
      default:
        break;
    }
    this.setState({
      formErrors: fieldValidationErrors,
      userIdValid: userIdValid,
      passwordValid: passwordValid
    })

  }
  validForm() {
    this.setState({
      formValid: this.state.userIdValid && this.state.passwordValid
    })
  }
  errorClass(error) {
    return error.length === 0 ? "" : "has-error"
  }
  handleOnClick = (e) => {
    e.preventDefault();
    register(this.state).then(data => {
      if (data.message == "Unauthorized") {
        let fieldValidationErrors = this.state.formErrors;
        fieldValidationErrors.error = ": incorrect credentials, please try again";
        this.setState({
          formValid: false,
          formErrors: fieldValidationErrors
        })
      }
     
    }).catch(e => {
      console.log("ERROR while logging from API...");
      console.log(e)
    });
    this.setState({
      isSuccess: true
    })
  }
  render() {
    if (this.state.isSuccess) {
      return <Redirect to='/'></Redirect>
    }
    else {
      return <div>
        <Header isLogged="no"></Header>

        <br />
        <Form className="registerForm">
          <h3>Sign Up</h3>
          <FormError formErrors={this.state.formErrors} />
          <Form.Group controlId="formBasicEmail">
            <Form.Control type="text" placeholder="Enter Username"
              onChange={this.handleOnChange}
              name="userId"
              value={this.state.userId}
              required />
          </Form.Group>

          <Form.Group controlId="formBasicPassword">
            <Form.Control type="password" placeholder="Password"
              onChange={this.handleOnChange}
              name="password"
              value={this.state.password}
              required
            />
          </Form.Group>
          <Form.Group controlId="formBasicfirstName">
            <Form.Control type="firstName" placeholder="FirstName"
              onChange={this.handleOnChange}
              name="firstName"
              value={this.state.firstName}
              required
            />
          </Form.Group>
          <Form.Group controlId="formBasicLastName">
            <Form.Control type="lastName" placeholder="LastName"
              onChange={this.handleOnChange}
              name="lastName"
              value={this.state.lastName}
              required
            />
          </Form.Group>

          <Form.Group controlId="formBasicContact">
            <Form.Control type="contact" placeholder="Contact"
              onChange={this.handleOnChange}
              name="contact"
              value={this.state.contact}
              required
            />
          </Form.Group>

          <Form.Group controlId="formBasicEmail">
            <Form.Control type="email" placeholder="Email"
              onChange={this.handleOnChange}
              name="email"
              value={this.state.email}
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

export default Register;