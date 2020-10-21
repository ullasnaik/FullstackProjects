import React from 'react';
import Dashboard from './Components/dashboard/Dashboard';
import Login from './Components/login/Login';

import {
  Route,
  BrowserRouter as Router,
} from 'react-router-dom';
import ReadNow from './Components/readNow/ReadNow';

class App extends React.Component {
  render() {
    return <div>
      <Router>
        <Route exact path='/' component={Login}></Route>
        <Route exact path='/dashboard' component={Dashboard}></Route>
        <Route exact path='/readNow' component={ReadNow}></Route>
      </Router>
    </div>
  }
}

export default App