import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import CssBaseline from "@mui/material/CssBaseline";
import Divider from "@mui/material/Divider";
import Drawer from "@mui/material/Drawer";
import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";
import DirectionsBusIcon from "@mui/icons-material/DirectionsBus";
import DirectionsIcon from "@mui/icons-material/Directions";
import ViewModuleIcon from "@mui/icons-material/ViewModule";
import PersonIcon from "@mui/icons-material/Person";
import PaidIcon from "@mui/icons-material/Paid";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import { Link, BrowserRouter as Router } from "react-router-dom";
import SiteRoute from "./Navigation/SiteRoute";
import Layout from "./Layout/Index";

const drawerWidth = 240;

function App(props) {
  const { window } = props;
  const [mobileOpen, setMobileOpen] = React.useState(false);

  const handleDrawerToggle = () => {
    setMobileOpen(!mobileOpen);
  };

  const container =
    window !== undefined ? () => window().document.body : undefined;
  console.log(props);
  return (
    <Box sx={{ display: "flex" }}>
      <CssBaseline />
      <Router>
        <AppBar
          position="fixed"
          sx={{
            width: { sm: `calc(100% - ${drawerWidth}px)` },
            ml: { sm: `${drawerWidth}px` },
          }}
        >
          <Layout
            handleClick={() => {
              handleDrawerToggle();
            }}
          />
        </AppBar>

        <Box
          component="nav"
          sx={{ width: { sm: drawerWidth }, flexShrink: { sm: 0 } }}
          aria-label="mailbox folders"
        >
          {/* The implementation can be swapped with js to avoid SEO duplication of links. */}
          <Drawer
            container={container}
            variant="temporary"
            open={mobileOpen}
            onClose={handleDrawerToggle}
            ModalProps={{
              keepMounted: true, // Better open performance on mobile.
            }}
            sx={{
              display: { xs: "block", sm: "none" },
              "& .MuiDrawer-paper": {
                boxSizing: "border-box",
                width: drawerWidth,
              },
            }}
          >
            <ListItem disablePadding>
              <ListItemButton component={Link} to="/">
                <ListItemIcon>
                  <ViewModuleIcon />
                </ListItemIcon>
                <ListItemText primary="Dashboard"></ListItemText>
              </ListItemButton>
            </ListItem>

            <ListItem disablePadding>
              <ListItemButton component={Link} to="/route-management">
                <ListItemIcon>
                  <DirectionsIcon />
                </ListItemIcon>
                <ListItemText primary="Route Management"></ListItemText>
              </ListItemButton>
            </ListItem>

            <ListItem disablePadding>
              <ListItemButton component={Link} to="/bus-manamgement">
                <ListItemIcon>
                  <DirectionsBusIcon />
                </ListItemIcon>
                <ListItemText primary="Bus Management"></ListItemText>
              </ListItemButton>
            </ListItem>

            <ListItem disablePadding>
              <ListItemButton component={Link} to="/user-management">
                <ListItemIcon>
                  <PersonIcon />
                </ListItemIcon>
                <ListItemText primary="Users"></ListItemText>
              </ListItemButton>
            </ListItem>

            <ListItem disablePadding>
              <ListItemButton component={Link} to="/fare-management">
                <ListItemIcon>
                  <PaidIcon />
                </ListItemIcon>
                <ListItemText primary="Fare Management"></ListItemText>
              </ListItemButton>
            </ListItem>
          </Drawer>
          <Drawer
            variant="permanent"
            sx={{
              display: { xs: "none", sm: "block" },
              "& .MuiDrawer-paper": {
                boxSizing: "border-box",
                width: drawerWidth,
              },
            }}
            open
          >
            <Toolbar />
            <Divider />
            <ListItem disablePadding>
              <ListItemButton component={Link} to="/">
                <ListItemIcon>
                  <ViewModuleIcon />
                </ListItemIcon>
                <ListItemText primary="Dashboard"></ListItemText>
              </ListItemButton>
            </ListItem>

            <ListItem disablePadding>
              <ListItemButton component={Link} to="/route-management">
                <ListItemIcon>
                  <DirectionsIcon />
                </ListItemIcon>
                <ListItemText primary="Route Management"></ListItemText>
              </ListItemButton>
            </ListItem>

            <ListItem disablePadding>
              <ListItemButton component={Link} to="/bus-manamgement">
                <ListItemIcon>
                  <DirectionsBusIcon />
                </ListItemIcon>
                <ListItemText primary="Bus Management"></ListItemText>
              </ListItemButton>
            </ListItem>

            <ListItem disablePadding>
              <ListItemButton component={Link} to="/user-management">
                <ListItemIcon>
                  <PersonIcon />
                </ListItemIcon>
                <ListItemText primary="Users"></ListItemText>
              </ListItemButton>
            </ListItem>

            <ListItem disablePadding>
              <ListItemButton component={Link} to="/fare-management">
                <ListItemIcon>
                  <PaidIcon />
                </ListItemIcon>
                <ListItemText primary="Fare Management"></ListItemText>
              </ListItemButton>
            </ListItem>
          </Drawer>
        </Box>
        <Box
          component="main"
          sx={{
            flexGrow: 1,
            p: 3,
            width: { sm: `calc(100% - ${drawerWidth}px)` },
          }}
        >
          <Toolbar />
          <SiteRoute />
        </Box>
      </Router>
    </Box>
  );
}

export default App;
