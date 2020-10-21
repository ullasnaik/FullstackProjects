import React from 'react';
import Home from './Components/home/Home';
import Login from './Components/login/Login';
import { BrowserRouter, Switch, Route } from "react-router-dom";

import MyFavourites from './Components/myFavourites/MyFavourites';
import { PrivateRoute } from './helpers/PrivateRoute';
import Register from './Components/register/Register';

class App extends React.Component {
  render() {
    return <BrowserRouter>
      <Switch>
        <Route exact path='/' component={Login}></Route>
        <Route exact path='/register' component={Register}></Route>
        <PrivateRoute exact path='/home' component={Home} />
        <PrivateRoute exact path='/myFavourites' component={MyFavourites} />
      </Switch>
    </BrowserRouter>
  }
}

export default App