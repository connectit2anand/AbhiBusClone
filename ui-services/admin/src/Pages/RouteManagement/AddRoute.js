import React, { useState } from "react";
import {
  Autocomplete,
  TextField,
  Button,
  Container,
  Grid,
} from "@mui/material";
import cityList from "./cityList.json";

function AddRoute() {
  const [fromCity, setFromCity] = useState(null);
  const [toCity, setToCity] = useState(null);
  const [distance, setDistance] = useState("");

  const handleFromCityChange = (event, newValue) => {
    setFromCity(newValue);
  };

  const handleToCityChange = (event, newValue) => {
    setToCity(newValue);
  };

  const handleDistanceChange = (event) => {
    setDistance(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    //Form submission
  };

  return (
    <Container maxWidth="sm">
      <h2>Add New Route</h2>
      <form onSubmit={handleSubmit}>
        <Grid container spacing={4}>
          <Grid item xs={12}>
            <Autocomplete
              options={cityList}
              getOptionLabel={(option) => option.city}
              value={fromCity}
              onChange={handleFromCityChange}
              renderInput={(params) => (
                <TextField {...params} label="From (City)" variant="outlined" />
              )}
            />
          </Grid>

          <Grid item xs={12}>
            <Autocomplete
              options={cityList}
              getOptionLabel={(option) => option.city}
              value={toCity}
              onChange={handleToCityChange}
              renderInput={(params) => (
                <TextField {...params} label="To (City)" variant="outlined" />
              )}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              label="Distance between"
              variant="outlined"
              value={distance}
              onChange={handleDistanceChange}
            />
          </Grid>
          <Grid item xs={12}>
            <Button type="submit" variant="contained" color="primary">
              Submit
            </Button>
          </Grid>
        </Grid>
      </form>
    </Container>
  );
}

export default AddRoute;
