import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from "./Navbar/Navbar";
import InternCard from "./InternCard/InternCard";
import Authentication from "./Authentication/Authentication";
import Calendar from "./Calendar/Calendar";
import Coordinator from "./Coordinator/Coordinator";
import CoordinatorDetails from "./CoordinatorDetails/CoordinatorDetails";

function App() {
  return (
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<InternCard />} />
            <Route exact path="/authenticate" element={<Authentication />} />
            <Route exact path="/calendar" element={<Calendar />} />
            <Route exact path="/coordinator" element={<Coordinator />} />
            <Route exact path="/coordinatorDetails" element={<CoordinatorDetails />} />
        </Routes>
      </Router>
  );
}

export default App;