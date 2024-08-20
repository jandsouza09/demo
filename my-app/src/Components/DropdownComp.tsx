import { Select, MenuItem, SelectChangeEvent, TextField, FormControl, InputLabel, Input, IconButton } from "@mui/material";
import React, { useCallback, useMemo, useState } from "react";
import InfiniteScroll from "react-infinite-scroll-component";
import { useDataContext } from "../Context/DataContext";
import { Clear } from "@mui/icons-material";

type DropdownProps = {
  options: { label: string | number; value: string | number }[];
  fetchMoreData?: () => void;
  hasMore?: boolean;
};

const DropdownComp = (props: DropdownProps) => {
  const { setSelectedPlayer, setYear, setFilterData } = useDataContext();
  const [selectedValue, setSelectedValue] = useState<string>('');

  const handleChange = (event: SelectChangeEvent) => {
    setSelectedValue(event.target.value as string);
    //setSelectedPlayer(event.target.value as string);
    setYear(parseInt(event.target.value));
  }

  const onClear = () => {
    setSelectedValue('');
    setSelectedPlayer(undefined);
    setYear(undefined);
    setFilterData(undefined);
  }

  return (
      // <InfiniteScroll
      //   dataLength={props.options.length}
      //   next={props.fetchMoreData}
      //   hasMore={props.hasMore}
      //   loader={<h4>Loading...</h4>}
      //   height={300}
      //   hasChildren={true}
      // >
      // </InfiniteScroll>
    <>
    <InputLabel sx={{marginBottom: '5px'}}>Select a year</InputLabel>
    <FormControl sx={{width: '300px', display: 'flex'}}>
      <div style={{display: 'flex', justifyContent: 'space-between' }}>
        <InputLabel id="demo-simple-select-label">Years</InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={selectedValue}
          onChange={handleChange}
          fullWidth
        >
          {props.options.map((option) => (
            <MenuItem key={option.value} value={option.value}>
              {option.label}
            </MenuItem>
          ))}
        </Select>
        <IconButton
          onClick={onClear} disableRipple
        >
          <Clear />
        </IconButton>
      </div>
    </FormControl></>
  );
};

export default DropdownComp;