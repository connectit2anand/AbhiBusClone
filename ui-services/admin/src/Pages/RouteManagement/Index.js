import { Box, Grid } from "@mui/material";
import React from "react";
import AddRoute from "./AddRoute";
import Routes from "./Routes";
// import { Container } from './styles';

export default function RouteManagement() {
  return (
    <Box container="main">
      <Grid container>
        <Grid item xs="12" md="6">
          <AddRoute />
        </Grid>
        <Grid item xs="12" md="6">
          <Routes />
        </Grid>
      </Grid>
    </Box>
  );
}
