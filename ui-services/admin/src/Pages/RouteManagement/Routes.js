import React from "react";
import {
  Table,
  TableHead,
  TableRow,
  TableCell,
  TableBody,
  Box,
} from "@mui/material";

const columns = [
  { id: "id", label: "ID", minWidth: 90 },
  { id: "to", label: "To", minWidth: 150 },
  { id: "from", label: "From", minWidth: 150 },
  { id: "distance", label: "Distance", minWidth: 150 },
];

const rows = [
  { id: 1, to: "City A", from: "City B", distance: "100 km" },
  { id: 2, to: "City C", from: "City D", distance: "150 km" },
  // Add more data rows
];

function Routes() {
  return (
    <Box>
      <h2>Routes</h2>
      <Table>
        <TableHead>
          <TableRow>
            {columns.map((column) => (
              <TableCell key={column.id} style={{ minWidth: column.minWidth }}>
                {column.label}
              </TableCell>
            ))}
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <TableRow key={row.id}>
              {columns.map((column) => (
                <TableCell key={column.id}>{row[column.id]}</TableCell>
              ))}
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </Box>
  );
}

export default Routes;
