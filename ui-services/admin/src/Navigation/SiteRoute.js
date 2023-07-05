import React from "react";
import { Route, Routes } from "react-router-dom";
import LandingPage from "../Pages/LandingPage";
import RouteManagement from "../Pages/RouteManagement/Index";

// import { Container } from './styles';

export default function SiteRoute() {
  return (
    <Routes>
      <Route path="/" element={<LandingPage />} />
      <Route path="/route-management" element={<RouteManagement />} />
    </Routes>
  );
}
