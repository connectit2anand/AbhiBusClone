import React from "react";
import { useLocation } from "react-router-dom";
import IconButton from "@mui/material/IconButton";
import InboxIcon from "@mui/icons-material/MoveToInbox";
import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";
import MailIcon from "@mui/icons-material/Mail";
import MenuIcon from "@mui/icons-material/Menu";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";

// import { Container } from './styles';

export default function Layout(props) {
  const location = useLocation();
  const pathname = location.pathname;

  const getPageTitle = () => {
    switch (pathname) {
      case "/home":
        return "Home Page";
      case "/route-management":
        return "Route Management";
      case "/":
        return "Dashboard";
      // Add more cases for each route
      default:
        return "Your App";
    }
  };

  return (
    <Toolbar>
      <IconButton
        color="inherit"
        aria-label="open drawer"
        edge="start"
        onClick={props.handleClick}
        sx={{ mr: 2, display: { sm: "none" } }}
      >
        <MenuIcon />
      </IconButton>
      <Typography variant="h6" noWrap component="div">
        {getPageTitle()}
      </Typography>
    </Toolbar>
  );
}
