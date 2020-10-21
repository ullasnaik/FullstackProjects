import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { login } from "../../Services/services";
import { Header } from '../header/Header';
import Footer from '../footer/Footer.jsx';
import { Redirect } from 'react-router';
import './login.css';
import { FormError } from './formError';

class Login extends React.Component {
  constructor() {
    super()
    this.state = {
      userId: "",
      password: "",
      token: "",
      formErrors: { userId: "", password: "" , error:""},
      userIdValid: false,
      passwordValid: false,
      formValid: false
    }
  }
  componentWillMount() {
    localStorage.removeItem("token");
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
    login(this.state).then(data => {
      if(data.message=="Unauthorized"){
        let fieldValidationErrors = this.state.formErrors;
        fieldValidationErrors.error = ": incorrect credentials, please try again";
        this.setState({
          formValid: false,
          formErrors: fieldValidationErrors
        })
      }
      localStorage.setItem("token", data.token);
      localStorage.setItem("userId", this.state.userId);
      this.setState({
        token: data.token
      })
    }).catch(e=>{
      console.log("ERROR while logging from API...")
    });
  }
  render() {
    if (this.state.token) {
      return <Redirect to='/Home'></Redirect>
    }
    else {
      return <div>
        <Header isLogged="no"></Header>

        <br />
        <Form className="loginForm">
          <h3>Idenfiy Yourself</h3>
          <FormError formErrors={this.state.formErrors} />
          <Form.Group controlId="formBasicEmail">
            <Form.Label>User name</Form.Label>
            <Form.Control type="text" placeholder="Enter Username"
              onChange={this.handleOnChange}
              name="userId"
              value={this.state.userId}
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