import './App.css';
import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Example from './pages/Example';
import Sidebar from "./pages/Sidebar";


const App = () => {
 return (
   <Router>
     <Home>
       <Routes>
         <Route path="/example" element = {< Example />} />
         <Route path="/menu" element = {<Sidebar />} />
       </Routes>
     </Home>
   </Router>
 );
};

export default App;
