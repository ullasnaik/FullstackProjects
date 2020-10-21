import React from 'react';
import Dashboad from './Components/dashboard/Dashboard';
import './App.css';
import Footer from './Components/footer/Footer';
import Header from './Components/header/Header';

class App extends React.Component {
  render() {

    return <div className='main-content' >
      <Header></Header>
      <Dashboad></Dashboad>
      <Footer></Footer> 
    </div>

  }
}
export default App;
