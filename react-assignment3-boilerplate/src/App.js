import React from 'react';
import Dashboard from './Components/dashboard/Dashboard';
import Login from './Components/login/Login';
import { BrowserRouter, Switch, Route } from "react-router-dom";

import ReadNow from './Components/readNow/ReadNow';
import { PrivateRoute } from './helpers/PrivateRoute';

class App extends React.Component {
  render() {
    return <BrowserRouter>
      <Switch>
        <Route exact path='/' component={Login}></Route>
        <PrivateRoute exact path='/dashboard' component={Dashboard} />
        <PrivateRoute exact path='/readNow' component={ReadNow} />
      </Switch>
    </BrowserRouter>
  }
}

export default App